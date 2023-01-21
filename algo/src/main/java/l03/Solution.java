package l03;

import java.util.Optional;

public class Solution {

  public static boolean isEmpty(int[] xs) {
    return xs.length == 0;
  }

  public static int head(int[] xs) {
    return xs[0];
  }

  public static Optional<int[]> tail(int[] xs) {
    if (isEmpty(xs)) return Optional.empty();
    int[] xsNew = new int[xs.length - 1];
    System.arraycopy(xs, 1, xsNew, 0, xs.length - 1);
    return Optional.of(xsNew);
  }

  public static int lengthR(int[] xs) {
    if (isEmpty(xs)) return 0;
    return 1 + lengthR(tail(xs).get());
  }

  public static int lengthTR(int[] xs) {
    return lengthTR(xs, 0);
  }

  private static int lengthTR(int[] xs, int acc) {
    if (isEmpty(xs)) return acc;
    return lengthTR(tail(xs).get(), 1 + acc);
  }

  public static int sumR(int[] xs) {
    if (isEmpty(xs)) return 0;
    return head(xs) + sumR(tail(xs).get());
  }

  private static int sumTR0(int[] xs, int acc) {
    if (isEmpty(xs)) return acc;
    return sumTR0(tail(xs).get(), head(xs) + acc);
  }

  private static int sumTR(int[] xs, int acc) {
    return tail(xs)
        .map(t -> sumTR(t, head(xs) + acc))
        .orElse(acc);
  }

  public static int sumTR(int[] xs) {
    return sumTR(xs, 0);
  }


  public static void main(String[] args) {
    int[] empty = {};
    int[] one = {10};
    int[] many = {10, 20, 30};

//    System.out.println(lengthR(empty)); // 0
//    System.out.println(lengthR(one)); // 1
//    System.out.println(lengthR(many)); // 3
//
//    System.out.println(lengthTR(empty)); // 0
//    System.out.println(lengthTR(one)); // 1
//    System.out.println(lengthTR(many)); // 3

//    System.out.println(sumR(empty)); // 0
//    System.out.println(sumR(one)); // 10
//    System.out.println(sumR(many)); // 60

    System.out.println(sumTR(empty)); // 0
    System.out.println(sumTR(one)); // 10
    System.out.println(sumTR(many)); // 60
  }


}
