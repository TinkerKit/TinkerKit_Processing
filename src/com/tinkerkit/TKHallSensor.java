package com.tinkerkit;

import cc.arduino.Arduino;

public class TKHallSensor extends TKAnalog {

  protected int zeroValue;

  public TKHallSensor(Arduino _arduino, int _port) {
    super(_arduino, _port);
    this.zeroValue = 512;
  }
  
  /**
   * used to find out the polarity of the magnet. 
   * @return a boolean for the polarity. TK.NORTH (true) or TK.SOUTH (false) 
   */
  public boolean polarity() {
    int value = get();
    if (value >= zeroValue)
      return TK.NORTH;
    else
      return TK.SOUTH;
  }
}