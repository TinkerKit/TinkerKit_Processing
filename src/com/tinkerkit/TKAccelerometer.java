package com.tinkerkit;

import cc.arduino.Arduino;

public class TKAccelerometer {

  protected final Arduino arduino;
  protected final int portX, portY;

  protected float gain;
  protected int zeroOffset;

  public TKAccelerometer(Arduino _arduino, int _portX, int _portY) {
    this.arduino = _arduino;
    this.portX = _portX;
    this.portY = _portY;

    this.gain = 1.414f;
    this.zeroOffset = 478;
  }

  /**
   * returns X axis acceleration value
   * @return an int for the X axis acceleration value
   */
  public int getXAxis() {
    return arduino.analogRead(portX);
  }

  /**
   * returns Y axis acceleration value
   * @return an int for the Y axis acceleration value
   */
  public int getYAxis() {
    return arduino.analogRead(portY);
  }
  
  /**
   * returns X axis acceleration value in G
   * @return a float for the X axis acceleration value in G
   */
  public float getXinG() {
    return (getXAxis() - zeroOffset) / 96.0f;
  }

  /**
   * returns Y axis acceleration value in G
   * @return a float for the Y axis acceleration value in G
   */
  public float getYinG() {
    return (getYAxis() - zeroOffset) / 96.0f;
  }

  /**
   * returns a value for the module inclination
   * @return an int for the module inclination
   */
  public int inclination() {
    int xVal = arduino.analogRead(portX) - zeroOffset;
    int yVal = arduino.analogRead(portY) - zeroOffset;

    if (xVal <= 96 && yVal <= 96) {
      float inclination = Double.valueOf(Math.atan2(xVal, yVal) * 180 / Math.PI).floatValue();
      return (int) inclination;
    } else return 0;
  }
}
