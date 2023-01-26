package l02;

public class Overflow {

  /**
   * 0..255
   * 0xxxxxxx  0...127 (128)
   * 1xxxxxxx -1..-128 (128)
   *
   * xxxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx
   * 0xxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx - positive
   * 1xxxxxxx xxxxxxxx xxxxxxxx xxxxxxxx - negative
   * 00000000 00000000 00000000 00000001 = 1
   *
   *  | x | y | & | | | ^ | r
   *  | - | - | - | - | - | -
   *  | - | + | - | + | + | +/- don't interest in
   *  | + | - | - | + | + | +/- don't interest in
   *  | + | + | + | + | - | +
   */
  public static boolean isOverflowWhenAdd(int x, int y) {
    int x_sign = x >> 31;
    int y_sign = y >> 31;
    if ((x_sign ^ y_sign) == 1) return false; // OK
    int r_sign = (x + y) >> 31;
    return r_sign == x_sign; // sign the same
  }

  public static boolean isOverflowWhenAdd2(int x, int y) {
    int r = x + y;
    // if and only if both arguments have the opposite sign of the result
    return ((x ^ r) & (y ^ r)) < 0;
  }

  public static void main(String[] args) {
    isOverflowWhenAdd(Integer.MAX_VALUE, 1);
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
