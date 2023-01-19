package l03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RecursionApp {

  public void a(int x) {
    a(x);
  }

  // ~10.000
  // simple, declarative, stack for free
  public int fact(int n) {
    if (n == 0) return 1;
    int n1 = fact(n - 1);
    int x = n * n1;
    return x;
  }

  private int fact2(int n, int r) {
    if (n == 0) return r;
    return fact2(n - 1, r * n);
  }

  public int fact2(int n) {
    return fact2(n, 1);
  }

  // easy => ... hard
  public int fact1(int n) {
    int r = 1;
    for (int i = 2; i <= n; i++) {
      r = r * i;
    }
    return r;
  }

  // -Xss4M
  public static void main1(String[] args) {
    System.out.println(args.length);
    for (String s: args)
      System.out.println(s);

    // 1.000.000 bytes per Thread
    RecursionApp r = new RecursionApp();
    System.out.println(r.fact(100000));
  }

  public int fibo(int n) {
    if (n == 1 || n == 2) return 1;
    return fibo(n - 1) + fibo(n - 2);
  }

  Map<Long, Long> cache = new HashMap<>();

  public long fibo2(long n) {
    if (n == 1 || n == 2) return 1;

    long fn;

    if (cache.containsKey(n)) fn = cache.get(n);
    else {
      fn = fibo2(n - 1) + fibo2(n - 2);
      cache.put(n, fn);
    }

    return fn;
  }

  public long fibo3(long nth) {
    long n1 = 1;
    long n2 = 1;
    long n = 0;

    for (int i = 3; i <= nth ; i++) {
      n = n1 + n2;
      n1 = n2;
      n2 = n;
    }

    return n;
  }

  public static void main2(String[] args) {
    RecursionApp r = new RecursionApp();
//    System.out.println(r.fibo(100));
//    System.out.println(r.fibo2(100));   // 3736710778780434371
    System.out.println(r.fibo3(100)); // 3736710778780434371
  }


  public boolean isEmpty(int[] xs) {
    return xs.length == 0;
  }

  public int head(int[] xs) {
    return xs[0];
  }

  public Optional<int[]> tail(int[] xs) {
    if (xs.length == 0) return Optional.empty();
    if (xs.length == 1) return Optional.empty();
    int[] xsNew = new int[xs.length-1];
    System.arraycopy(xs, 1, xsNew, 0, xs.length - 1);
    return Optional.of(xsNew);
  }

  public int lengthR(int[] xs) {
    throw new IllegalArgumentException("to implement");
  }

  public int lengthTR(int[] xs) {
    throw new IllegalArgumentException("to implement");
  }

  public int sumR(int[] xs) {
    throw new IllegalArgumentException("to implement");
  }

  public int sumTR(int[] xs) {
    throw new IllegalArgumentException("to implement");
  }


  public static void main(String[] args) {
    RecursionApp r = new RecursionApp();
    int[] empty = new int[0];
    int[] one = {333};
    int[] data = {1,2,3};
    System.out.println(r.tail(empty)); // Optional.empty
    System.out.println(r.tail(one)); // Optional.empty
    r.tail(data).ifPresent(x -> System.out.println(Arrays.toString(x))); // Optional.of([2, 3])
  }


}
