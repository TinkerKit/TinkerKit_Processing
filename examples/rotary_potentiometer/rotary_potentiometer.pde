import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the potentiometer
TKPotentiometer pot;

float minVal = 1023;
float maxVal = 0;

void setup() {  

  size(512, 512);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    

  //for every tinkerkit component we have to pass
  //the arduino and the port
  pot = new TKPotentiometer(arduino, TK.I0);

  noStroke();
}

void draw() {

  background(200);

  //get the potentiometer values
  float val = pot.get();

  //calibration
  if (val < minVal) minVal = val;
  if (val > maxVal) maxVal = val;  

  //map the values of the potentiometer
  //on a range of 180 (the degrees of rotation)
  val = map(val, minVal, maxVal, 0, 180);
  
  //translate and rotate according to the potentiometer
  translate(width/2, height/2);
  rotate(radians(val));
  
  //draw a rectangle 
  fill(255);
  rectMode(CENTER);
  rect(0, 0, 200, 25);

  //print the potentiometer values
  println(val);
}

