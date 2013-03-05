/*
Joystick Example
by Matteo Loglio (http://matlo.me)

display a circle whose position
is determined by the joystick values

remember to upload standardFirmata on the
Arduino board.
*/
import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the joystick
TKJoystick joystick;

void setup() {  

  size(512,512);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
  
  //for every tinkerkit component we have to pass
  //the arduino and the port
  joystick = new TKJoystick(arduino, TK.I0, TK.I1);
  
  //style
  noStroke();
  fill(255);
  smooth();
}

void draw() {

 background(200);
 
 //get joystick values
 float x = joystick.getXAxis();
 float y = joystick.getYAxis(); 
 
 //map values on the window width and height
 x = map(x,0,1023,0,width);
 y = map(y,0,1023,0,height);
 
 ellipse(x,y,30,30);
 
 println("x: " + x + " , y: " + y);
  
}
