
//#include <BluetoothSerial.h>
#include <SoftwareSerial.h>

SoftwareSerial bluetoothSerial(1,0);  //RX , TX

#include <Servo.h>

char data = 0;  //declaring Variable for storing received data from bluetooth

/*Smart Led PINS*/
const int led_1_1 = 2;
const int led_1_2 = 3;
const int led_2_1 = 5;
const int led_2_2 = 4;

/*Servo PINS*/
Servo servo1;
Servo servo2;

const int pinServo_1=9;
const int pinServo_2=10;

void setup() {
  Serial.begin(9600);  // baud rate for serial data transmission
  
  bluetoothSerial.begin(9600);  //for bluetooth

  pinMode(led_1_1, OUTPUT);  //Initialize pin as output.
  pinMode(led_1_2, OUTPUT);  //Initialize pin as output.
  pinMode(led_2_1, OUTPUT);  //Initialize pin as output.
  pinMode(led_2_2, OUTPUT);  //Initialize pin as output.

  servo1.attach(pinServo_1);
  servo2.attach(pinServo_2);
 
  /*initial state no reservation*/
  digitalWrite(led_1_1, LOW);
  digitalWrite(led_1_2, HIGH);
  digitalWrite(led_2_1, HIGH);
  digitalWrite(led_2_2, LOW);
}

/*Led Reservation*/

void LED_Reservation(char d) 
 {
  /*Slot 1 Reserved*/
  if (d == '1') {
    digitalWrite(led_1_2, HIGH);
    digitalWrite(led_1_1, LOW);
  }

  /*Slot 1 UnReserved*/
  if (d == '2') {
    digitalWrite(led_1_1, HIGH);
    digitalWrite(led_1_2, LOW);
  }

  /*Slot 2 Reserved*/
  if (d == '4') {
    digitalWrite(led_2_2, HIGH);
    digitalWrite(led_2_1, LOW);
  }

  /*Slot 2 UnReserved*/
  if (d == '3') {
    digitalWrite(led_2_1, HIGH);
    digitalWrite(led_2_2, LOW);
  }

 }

 void Servo_parking(char d){

   /*Arrived at slot 1*/
   if(d == '1'){
     servo1.write(90);
   }

  /*leave at slot 1*/
  if(d == '2'){
     servo1.write(-90);
  }

  /*leave at slot 2*/
  if(d == '3'){
     servo2.write(90);
  }

   /*arrive slot 2*/
  if(d == '4'){
     servo2.write(-90);
  }

}

void loop() 
{

  if (Serial.available() > 0)  // checks if any data is received through serial monitor
  {
    data = Serial.read(); /*Reading any receiving data and storing it into variable named data*/
    //for debug
    Serial.print(data);  //displaying the data
    Serial.print("\n");  //adding space by giving a New line
  }

  // if (bluetoothSerial.available() > 0)  // checks if any data is received through serial monitor
  // {
  //   data = bluetoothSerial.read(); /*Reading any receiving data and storing it into variable named data*/
  //   //for debug
  //  // Serial.print(data);  //displaying the data
  //  // Serial.print("\n");  //adding space by giving a New line
  // }

  LED_Reservation(data);

  Servo_parking(data);

}
