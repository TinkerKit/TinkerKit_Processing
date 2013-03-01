import processing.serial.*;
import cc.arduino.*;

Arduino arduino;

TKAccelerometer acc;

void setup() {  
  //cento, cento!
  size(100,100);
  
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
  
  acc = new TKAccelerometer(arduino, I1, I0);
}

void draw() {
  
  println(acc.inclination());
  
}