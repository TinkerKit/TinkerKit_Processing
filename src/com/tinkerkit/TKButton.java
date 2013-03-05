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
  
  /**
   * returns if the button is pressed or not.
   * @return a boolean that is HIGH (true) or LOW (false)
   */
  public boolean get() {
    int val = arduino.analogRead(port);
    boolean b;
    if (val < 500) b = false;
    else b = true;
    return b;
  }

  /**
   * detects when the button is toggled 
   * @return a boolean value that changes once the button is toggled
   */
  public boolean toggle() {
    oldState = currentState;
    currentState = get();

    if ((currentState == TK.HIGH) && (oldState == TK.LOW))
      toggleState = !toggleState;
    oldState = currentState;

    return toggleState;
  }
  
  /**
   * detects when the button is pressed
   * @return a true boolean once the button is pressed
   */
  public boolean pressed() {
    currentState = get();
    if (currentState == TK.HIGH && oldState == TK.LOW) {
      oldState = currentState;
      TK.sleep(50);
      return true;
    } else
      return false;
  }
  
  /**
   * detects when the button is released
   * @return a true boolean once the button is released
   */
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
  
  /**
   * detects when the button is held
   * @return a true boolean once the button is held
   */
  public boolean held() {
    if (released() == TK.LOW && oldState == TK.HIGH)
      return true;
    else
      return false;
  }

}
