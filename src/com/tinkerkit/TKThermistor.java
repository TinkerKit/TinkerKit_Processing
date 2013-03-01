package com.tinkerkit;

import cc.arduino.Arduino;

public class TKThermistor extends TKAnalog {

  protected float ADCres;
  protected int Beta;
  protected float Kelvin;
  protected int Rb;
  protected float Ginf;

  public TKThermistor(Arduino _arduino, int _port) {
    super(_arduino, _port);
    this.ADCres = 1023f;
    this.Beta = 3950;
    //0K
    this.Kelvin = 273.15f;
    //10 kOhm
    this.Rb = 10000;
    //Rinf = R0*e^(-Beta/T0) = 4700*e^(-3950/298.15)
    //Ginf = 1/Rinf
    this.Ginf = 120.6685f;
  }

  public float getCelsius() {
    float Rthermistor = Rb * (ADCres / get() - 1);
    float _temperatureC = Beta / (float) (Math.log(Rthermistor * Ginf));
    return _temperatureC - Kelvin;
  }

  public float getFahrenheit() {
    return (getCelsius() * 9.0f) / 5.0f + 32.0f;
  }
}