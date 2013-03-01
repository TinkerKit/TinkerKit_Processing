package com.tinkerkit;

import cc.arduino.Arduino;

public class TKAnalog {

  protected final Arduino arduino;
  protected final int port;

  public TKAnalog(Arduino _arduino, int _port) {
    this.arduino = _arduino;
    this.port = _port;
    this.arduino.pinMode(port, Arduino.INPUT);
  }

  public int get() {
    return arduino.analogRead(port);
  }
}
