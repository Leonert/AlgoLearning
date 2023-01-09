package l01;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SortApp {

    static int accessCount = 0;
    static int swapCount = 0;
    public static void sort(int[] xs) {
        for (int i=0; i< xs.length; i++)
            for (int j=i+1; j < xs.length; j++) {
                System.out.printf("i:%d xs[%d]:%d j:%d xs[%d]:%d", i, i, xs[i], j, j, xs[j]);
                accessCount++;
                if (xs[i] > xs[j]) {
                    System.out.println("-- swapping");
                    int x = xs[i];
                    xs[i] = xs[j];
                    xs[j] = x;
                    System.out.println(Arrays.toString(xs));
                    swapCount++;
                } else {
                    System.out.println("-- skipping");
                }

            }
    }

    public static int inc(int x) {
        return x + 1;
    }

    public static void main(String[] args) {
        IntUnaryOperator adder1 = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                return x+1;
            }
        };
        IntUnaryOperator adder2 = (int x) -> x + 1;
        UnaryOperator<Integer> adder2a = (Integer x) -> x + 1;
        IntUnaryOperator adder3 = (int x) -> { return x + 1; };
        IntUnaryOperator adder4 = x -> x + 1;

//        int[] n = {50};
//        int n = 50;
        int[] random = Stream
                .generate(() -> (int) (Math.random() * 100))
//                .generate(() -> --n)
//                .generate(() -> --n[0])
                .mapToInt(a -> a)
                .limit(30)
//                .map(new IntUnaryOperator() {
//                    @Override
//                    public int applyAsInt(int operand) {
//                        return operand+1;
//                    }
//                })
//                .map(adder1)
//                .map(SortApp::inc) // method reference // constructor reference
                .toArray();
        System.out.println(Arrays.toString(random));
        sort(random);
        System.out.println(Arrays.toString(random));
        System.out.printf("AccessCount: %d\n", accessCount);
        System.out.printf("SwapCount: %d\n", swapCount);
    }

}
