package com.tinkerkit;

import cc.arduino.Arduino;

public class TKTiltSensor {

  protected final int port;
  protected final Arduino arduino;

  public TKTiltSensor(Arduino _arduino, int _port) {
    this.port = _port;
    this.arduino = _arduino;
    this.arduino.pinMode(port, Arduino.INPUT);
  }
  
  /**
   * get the tilt sensor value. 
   * @return a boolean value for the state of the sensor
   */
  public boolean get() {
    int val = arduino.analogRead(port);
    boolean b;
    if (val < 500) b = false;
    else b = true;
    return b;
  }

}
