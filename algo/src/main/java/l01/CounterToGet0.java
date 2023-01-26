package l01;

public class CounterToGet0 {


    public static void main(String[] args) {
        System.out.println(countTo0(14));
    }

    private static int countTo0(int num) {
        if (num == 0) return 0;
        int counter = 0;
        while (num != 0) {
            counter += (num & 1) == 1? 2 : 1;
            num >>= 1;
        }
        return counter - 1;
    }
}
