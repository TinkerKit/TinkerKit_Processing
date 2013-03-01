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

  public int getXAxis() {
    return arduino.analogRead(portX);
  }

  public int getYAxis() {
    return arduino.analogRead(portY);
  }

  public float getXinG() {
    return (getXAxis() - zeroOffset) / 96.0f;
  }

  public float getYinG() {
    return (getYAxis() - zeroOffset) / 96.0f;
  }

  public int inclination() {
    int xVal = arduino.analogRead(portX) - zeroOffset;
    int yVal = arduino.analogRead(portY) - zeroOffset;

    if (xVal <= 96 && yVal <= 96) {
      float inclination = Double.valueOf(Math.atan2(xVal, yVal) * 180 / Math.PI).floatValue();
      return (int) inclination;
    } else return 0;
  }
}
