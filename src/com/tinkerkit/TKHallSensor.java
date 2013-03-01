package com.tinkerkit;

import cc.arduino.Arduino;

public class TKHallSensor extends TKAnalog {

  protected int zeroValue;

  public TKHallSensor(Arduino _arduino, int _port) {
    super(_arduino, _port);
    this.zeroValue = 512;
  }

  public boolean polarity() {
    int value = get();
    if (value >= zeroValue)
      return TK.NORTH;
    else
      return TK.SOUTH;
  }
}