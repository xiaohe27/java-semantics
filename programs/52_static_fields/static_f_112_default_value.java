/*
Field default values. Class with fields of all relevant types, without initializer.
Test their value.
*/

class A {
  static byte b;
  static short s;
  static int i;
  static long l;
  static char ch;
  static boolean bool;
  static String str;
  static RuntimeException re;
}

public class static_f_112_default_value {
  public static void main(String[] args) {
    System.out.println("" + A.b + " " + A.s + " " + A.i + " " + A.l + " " + A.ch + " " + A.bool
                    + " " + A.str + " " + A.re + " ");
    System.out.println("Done!");
  }
}
