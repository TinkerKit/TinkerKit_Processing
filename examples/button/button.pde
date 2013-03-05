/*
Button Example
by Matteo Loglio (http://matlo.me)

change the background color to black 
if the button is pressed

remember to upload standardFirmata on the
Arduino board.
*/
import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the button
TKButton but;

void setup() {  

  size(100,100);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
  
  //for every tinkerkit component we have to pass
  //the arduino and the port
  but = new TKButton(arduino, TK.I0);
}

void draw() {
 //if the button is pressed, change the background to black 
  if (but.get() == TK.HIGH) background(0);
  else background(255);

  //print the button values
  println(but.get());
}
