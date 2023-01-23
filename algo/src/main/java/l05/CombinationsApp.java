package l05;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationsApp {

  public static List<String> comb3(List<String> prev) {
    throw new IllegalStateException();
  }

  // "0"+ every item
  // "1"+ every item
  public static List<String> comb(int n) {
    if (n == 0) return Collections.singletonList("");
    return Stream.of("0", "1")
        .flatMap(digit ->
            comb(n - 1).stream() // previous structure
                .map(prev_item ->
                    digit + prev_item
            )
        )
        .collect(Collectors.toList());
  }

  public static Stream<String> comb2(int n) {
    return n == 0 ? Stream.of("") :
        Stream.of("0", "1")
            .flatMap(digit ->
                comb2(n - 1) // previous structure
                    .map(prev_item ->
                        digit + prev_item
                )
            );
  }

  public static void main2(String[] args) {
    List<String> comb1 = comb(1); // 0, 1
    System.out.println(comb1);
    List<String> comb2 = comb(2); // 00, 01, 10, 11
    System.out.println(comb2);
    List<String> comb3 = comb(3); // 000, 001, 010, 011, 100, 101, 110, 111
    System.out.println(comb3);
  }

  public static void main(String[] args) {
    List<String> comb1 = comb2(1).collect(Collectors.toList()); // 0, 1
    System.out.println(comb1);
    List<String> comb2 = comb2(2).collect(Collectors.toList()); // 00, 01, 10, 11
    System.out.println(comb2);
    List<String> comb3 = comb2(3).collect(Collectors.toList()); // 000, 001, 010, 011, 100, 101, 110, 111
    System.out.println(comb3);
  }

  public static void main1(String[] args) {
    Stream.of(1, 2, 3)
        .map(x -> Stream.of(x, x*10, x*100))
        .forEach(System.out::println);
  }

}
