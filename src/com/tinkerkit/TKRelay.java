package com.tinkerkit;

import cc.arduino.Arduino;

public class TKRelay extends TKOut {

  public TKRelay(Arduino _arduino, int _port) {
    super(_arduino, _port);
  }
}