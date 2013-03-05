package com.tinkerkit;

import cc.arduino.Arduino;

public class TKLed extends TKOut {

  public TKLed(Arduino _arduino, int _port) {
    super(_arduino, _port);
  }

  /**
   * set the brightness of the LED
   * @param val the brightness int value, from 0 to 1023
   */
  public void brightness(int val) {
    if (val <= TK.TKMAX && val >= 0) {
      arduino.analogWrite(port, val / 4);
      if (val == 0) state = false;
      else state = true;
    } else return;
  }

}