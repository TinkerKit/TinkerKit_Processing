package com.tinkerkit;

import cc.arduino.Arduino;

public class TKJoystick {

  protected final Arduino arduino;
  protected final int portX, portY;

  public TKJoystick(Arduino _arduino, int _portX, int _portY) {
    this.arduino = _arduino;
    this.portX = _portX;
    this.portY = _portY;
  }

  public int getXAxis() {
    return arduino.analogRead(portX);
  }

  public int getYAxis() {
    return arduino.analogRead(portY);
  }
}