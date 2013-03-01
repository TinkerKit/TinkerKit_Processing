package com.tinkerkit;

import cc.arduino.Arduino;

public class TKOut {

  protected final Arduino arduino;
  protected final int port;

  protected boolean state;

  public TKOut(Arduino _arduino, int _port) {
    this.port = _port;
    this.arduino = _arduino;
    this.arduino.pinMode(port, Arduino.OUTPUT);

    this.state = false;
  }

  public void set(int val) {
    arduino.digitalWrite(port, val);
  }

  public boolean state() {
    return state;
  }

  public void on() {
    set(Arduino.HIGH);
    this.state = true;
  }

  public void off() {
    set(Arduino.LOW);
    this.state = false;
  }

}
