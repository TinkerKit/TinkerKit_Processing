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
  /**
   * the general get() method for the analog sensors.
   * @return an int value from 0 to 1023
   */
  public int get() {
    return arduino.analogRead(port);
  }
}
