package com.tinkerkit;

public class TK {

  public static final int O0 = 11;
  public static final int O1 = 10;
  public static final int O2 = 9;
  public static final int O3 = 6;
  public static final int O4 = 5;
  public static final int O5 = 3;

  public static final int I0 = 0;
  public static final int I1 = 1;
  public static final int I2 = 2;
  public static final int I3 = 3;
  public static final int I4 = 4;
  public static final int I5 = 5;

  public static final int TKMAX = 1023;
  public static final boolean TK_X1 = false;
  public static final boolean TK_X4 = true;
  public static final boolean NORTH = true;
  public static final boolean SOUTH = false;

  public static final boolean HIGH = true;
  public static final boolean LOW = false;

  public static final boolean ON = true;
  public static final boolean OFF = false;

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
