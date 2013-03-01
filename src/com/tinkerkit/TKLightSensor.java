package com.tinkerkit;

import cc.arduino.Arduino;

public class TKLightSensor extends TKAnalog {

  public TKLightSensor(Arduino _arduino, int _port) {
    super(_arduino, _port);
  }
}