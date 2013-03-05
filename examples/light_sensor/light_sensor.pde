import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

//declare the joystick
TKLightSensor ldr;

void setup() {  

  size(256,256);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
  
  //for every tinkerkit component we have to pass
  //the arduino and the port
  ldr = new TKLightSensor(arduino, TK.I0);
}

void draw() {

 //read the light sensor
 float val = ldr.get();
 
 //map the ldr values (0,1023) on the grayscale (0,255)
 val = map(val, 0, 1023, 0, 255);
  
 //set the background according to the light sensor 
 background(val);
 
 println(val);
  
}
