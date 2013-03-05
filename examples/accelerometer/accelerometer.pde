import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the accelerometer
TKAccelerometer acc;

void setup() {  

  size(512,512);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
  
  //for every tinkerkit component we have to pass
  //the arduino and the port
  acc = new TKAccelerometer(arduino, TK.I0, TK.I1);
  
  //style
  noStroke();
  fill(255);
  smooth();
}

void draw() {

 background(200);
 
 //get accelerometer values
 float x = acc.getXAxis();
 float y = acc.getYAxis(); 
 
 //map values on the window width and height
 x = map(x,0,1023,0,width);
 y = map(y,0,1023,0,height);
 
 ellipse(x,y,30,30);
 
 println("x: " + x + " , y: " + y);
  
}
