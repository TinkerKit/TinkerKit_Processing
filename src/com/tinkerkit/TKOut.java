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
  
  /**
   * set a value on the output
   * @param val an analog int value from 0 to 1023 
   */
  public void set(int val) {
    arduino.digitalWrite(port, val);
  }

  /**
   * return the state of the output, true if it's on (any value above zero for PWM outputs), false if it's off (zero).  
   */
  public boolean state() {
    return state;
  }

  /**
   * turns the output on at the maximum value, basically writes 1023 on the selected pin. 
   */
  public void on() {
    set(Arduino.HIGH);
    this.state = true;
  }

  /**
   * turns the output off
   */
  public void off() {
    set(Arduino.LOW);
    this.state = false;
  }

}
