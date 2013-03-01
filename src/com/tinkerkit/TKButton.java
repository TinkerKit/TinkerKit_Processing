package com.tinkerkit;

import cc.arduino.Arduino;

public class TKButton {

  protected final int port;
  protected final Arduino arduino;

  protected boolean toggleState;
  protected boolean currentState;
  protected boolean oldState;

  public TKButton(Arduino _arduino, int _port) {
    this.port = _port;
    this.arduino = _arduino;
    this.arduino.pinMode(port, Arduino.INPUT);

    this.toggleState = TK.LOW;
    this.currentState = TK.LOW;
    this.oldState = TK.LOW;
  }

  public boolean get() {
    int val = arduino.analogRead(port);
    boolean b;
    if (val < 500) b = false;
    else b = true;
    return b;
  }

  public boolean toggle() {
    oldState = currentState;
    currentState = get();

    if ((currentState == TK.HIGH) && (oldState == TK.LOW))
      toggleState = !toggleState;
    oldState = currentState;

    return toggleState;
  }

  public boolean pressed() {
    currentState = get();
    if (currentState == TK.HIGH && oldState == TK.LOW) {
      oldState = currentState;
      TK.sleep(50);
      return true;
    } else
      return false;
  }

  public boolean released() {
    oldState = currentState;
    currentState = get();

    if (currentState == TK.LOW && oldState == TK.HIGH) {
      oldState = currentState;
      TK.sleep(50);
      return true;
    } else
      return false;
  }

  public boolean held() {
    if (released() == TK.LOW && oldState == TK.HIGH)
      return true;
    else
      return false;
  }

}
