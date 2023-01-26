package l01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SortApp {
    static int accessCount = 0;

    static int swapCount = 0;

    public static void main(String[] args) {
        IntUnaryOperator adder1 = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                return x + 1;
            }
        };
        IntUnaryOperator adder2 = (int x) -> x + 1;
        UnaryOperator<Integer> adder2a = (Integer x) -> x + 1;
        IntUnaryOperator adder3 = (int x) -> {
            return x + 1;
        };
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

    public static void sort(int[] xs) {
        for (int i = 0; i < xs.length; i++)
            for (int j = i + 1; j < xs.length; j++) {
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

    public static <A> void sortGen(A[] xs, Comparator<A> cmp) {
        for (int i = 0; i < xs.length; i++)
            for (int j = i + 1; j < xs.length; j++) {
                System.out.printf("i:%d xs[%d]:%s j:%d xs[%d]:%s", i, i, xs[i], j, j, xs[j]);
                accessCount++;
                if (cmp.compare(xs[i], xs[j]) > 0) {
                    System.out.println("-- swapping");
                    A x = xs[i];
                    xs[i] = xs[j];
                    xs[j] = x;
                    System.out.println(Arrays.toString(xs));
                    swapCount++;
                } else {
                    System.out.println("-- skipping");
                }

            }
    }

    public static <A extends Comparable<A>> void sortGen(A[] xs) {
        for (int i = 0; i < xs.length; i++)
            for (int j = i + 1; j < xs.length; j++) {
                System.out.printf("i:%d xs[%d]:%s j:%d xs[%d]:%s", i, i, xs[i], j, j, xs[j]);
                accessCount++;
                if (xs[i].compareTo(xs[j]) > 0) {
                    System.out.println(" -- swapping");
                    A x = xs[i];
                    xs[i] = xs[j];
                    xs[j] = x;
                    System.out.println(Arrays.toString(xs));
                    swapCount++;
                } else {
                    System.out.println(" -- skipping");
                }

            }
    }

    public static int inc(int x) {
        return x + 1;
    }

    static class Pizza implements Comparable<Pizza> {
        int size;

        public Pizza(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "size=" + size +
                    '}';
        }

        @Override
        public int compareTo(Pizza that) {
            return Integer.compare(this.size, that.size);
        }
    }

    public static void main1(String[] args) {
        Pizza[] pizzas = {new Pizza(100), new Pizza(10), new Pizza(20)};
        Comparator<Pizza> pc = new Comparator<Pizza>() {
            @Override
            public int compare(Pizza o1, Pizza o2) {
                return Integer.compare(o1.size, o2.size);
            }
        };
        System.out.println(Arrays.toString(pizzas));
        sortGen(pizzas); // by compareTo (Pizza implements Comparable<Pizza>)
        sortGen(pizzas, pc); // by ANY comparator provided
        System.out.println(Arrays.toString(pizzas));
    }

    // a - sorted
    // b - sorted
    // c - must be sorted
    // O(a.length + b.length)
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        // ...
        return c;
    }

}
