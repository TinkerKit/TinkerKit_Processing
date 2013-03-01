package com.tinkerkit;

import cc.arduino.Arduino;

public class TKPotentiometer extends TKAnalog {

  public TKPotentiometer(Arduino _arduino, int _port) {
    super(_arduino, _port);
  }
}