/*
Empty Example
by Matteo Loglio (http://matlo.me)

an empty sketch for starter, your
own project as dessert.

remember to upload standardFirmata on the
Arduino board.
*/
import processing.serial.*;
import cc.arduino.*;
import com.tinkerkit.*;

Arduino arduino;

void setup() {  

  size(256,256);

  println(Arduino.list());
  arduino = new Arduino(this, Arduino.list()[0], 57600);    
}

void draw() {  
  
}
