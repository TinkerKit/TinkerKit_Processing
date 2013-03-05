package com.tinkerkit;

import cc.arduino.Arduino;

public class TKMosFet extends TKOut {

  public TKMosFet(Arduino _arduino, int _port) {
    super(_arduino, _port);
  }
  
  /**
   * write the value on the MosFet
   * @param val the int value passed to the MosFet
   */
  public void set(int val) {
    if (val <= TK.TKMAX && val >= 0) {
      arduino.analogWrite(port, val / 4);
      if (val == 0) state = false;
      else state = true;
    } else return;
  }
}
