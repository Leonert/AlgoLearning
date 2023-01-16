package l02;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Overflow {

  public static boolean isOverflowWhenAdd(int x, int y) {
    throw new IllegalArgumentException("to implement");
  }

  public static boolean isOverflowWhenSub(int x, int y) {
    throw new IllegalArgumentException("to implement");
  }

  public static boolean isOverflowWhenMul(int x, int y) {
    throw new IllegalArgumentException("to implement");
  }

  public static boolean isOverflow(int x, int y, BiFunction<Integer, Integer, Integer> f) {
    throw new IllegalArgumentException("to implement");
  }

  public static void main(String[] args) {
    isOverflow(Integer.MAX_VALUE, 1, (a, b) -> a + b)
  }

  public static void main1(String[] args) {
    // +a + +b => -????
    int i = Integer.MAX_VALUE + 1;
    System.out.println(i);

    // -a -b => +????
    int j = Integer.MIN_VALUE - 1;
    System.out.println(j);
  }

}
