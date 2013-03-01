package com.tinkerkit;

import cc.arduino.Arduino;

public class TKGyro {

  protected final Arduino arduino;
  protected final int portX, portY;

  protected boolean model;
  protected long sensitivityInCount;
  protected int yZeroVoltage;
  protected int xZeroVoltage;

  public TKGyro(Arduino _arduino, int _portX, int _portY, boolean _model) {
    this.arduino = _arduino;
    this.portX = _portX;
    this.portY = _portY;

    this.model = _model;
    this.sensitivityInCount = 14633; // 4.88mV / (0.167mV/dps * 2)
    if (model == TK.TK_X4) {
      this.sensitivityInCount /= 4;
    }
    this.yZeroVoltage = 503;
    this.xZeroVoltage = 503;
  }

  public int getXAxis() {
    return arduino.analogRead(portX);
  }

  public int getYAxis() {
    return arduino.analogRead(portY);
  }

  public void calibrate() {
    xZeroVoltage = 0;
    yZeroVoltage = 0;

    for (int i = 0; i < 50; i++) {
      yZeroVoltage += getYAxis();
      xZeroVoltage += getXAxis();
      TK.sleep(20);
    }
    yZeroVoltage /= 50;
    xZeroVoltage /= 50;
  }

  public long getXAxisRate() {
    return ((long) (getXAxis() - xZeroVoltage) * sensitivityInCount) / 1000;
  }

  public long getYAxisRate() {
    return ((long) (getYAxis() - yZeroVoltage) * sensitivityInCount) / 1000;
  }
}