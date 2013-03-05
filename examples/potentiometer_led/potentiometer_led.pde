import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the modules
TKPotentiometer pot;
TKLed led;

float minVal = 1023;
float maxVal = 0;

void setup() {  

  size(512, 512);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    

  //for every tinkerkit component we have to pass
  //the arduino and the port
  pot = new TKPotentiometer(arduino, TK.I0);
  led = new TKLed(arduino, TK.O0);

  stroke(255);
  strokeWeight(3);
  smooth();
}

void draw() {

  background(200);

  //get the potentiometer values
  int val = pot.get();  

  //calibration
  if (val < minVal) minVal = val;
  if (val > maxVal) maxVal = val;    
  
  //map the values of the potentiometer
  //on the width of the window with a 50px margin 
  float x = map(val, minVal, maxVal, 50, width-50); 
  //then on the 255 scale for the opacity
  float opacity = map(val, minVal, maxVal, 0, 255);

  //draw a circle with opacity related to the value
  fill(255, opacity);
  ellipse(x, height/2, 50, 50);

  //set the led brightness in correspondence to val
  led.brightness(val);

  //print the potentiometer values
  println(val);
}

