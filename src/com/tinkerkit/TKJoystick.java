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
  
  /**
   * read the X axis
   * @return a value from 0 to 1023 where 512 is the center
   */
  public int getXAxis() {
    return arduino.analogRead(portX);
  }

  /**
   * read the Y axis
   * @return a value from 0 to 1023 where 512 is the center
   */
  public int getYAxis() {
    return arduino.analogRead(portY);
  }
}