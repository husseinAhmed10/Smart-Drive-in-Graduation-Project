//#include <BluetoothSerial.h>
#include <SoftwareSerial.h>

SoftwareSerial bluetoothSerial(1,0);  //RX , TX

char data = 0;  //declaring Variable for storing received data from bluetooth

#include <Wire.h>
#include <LiquidCrystal_I2C.h>
 
// Define instance for LCD I2C display
LiquidCrystal_I2C lcd(0x27, 16, 2);

#include <Servo.h>


/*Smart Led PINS*/
const int led_1_1 = 2;
const int led_1_2 = 3;


/*Servo PINS*/
Servo servo1;

const int pinServo_1=9;

/*Smart lightneing Pins*/
//Declare a variable used later in the program.
#define ldr_1 A1
#define smart_led1 13 //A3

int ldrValue_1; //Declare variable of type (int) and name (ldrValue)

/*Buzzer and sensor , light*/
#define LED 4
#define Buzzer 5
//#define Sensor A0


void setup() {
  Serial.begin(9600);  // baud rate for serial data transmission
  
  bluetoothSerial.begin(9600);  //for bluetooth
  
  //counting down
  lcd.init();       // Initialize the LCD display screen
  lcd.backlight();  // Turn on backlight of LCD display screen.
 
  // Print a message to the LCD.
  lcd.setCursor(0, 0);          // Go to position column 2 & row 1
  lcd.print("Slot Available");   // Print "Hello, World!"



  pinMode(led_1_1, OUTPUT);  //Initialize pin as output.
  pinMode(led_1_2, OUTPUT);  //Initialize pin as output.


  servo1.attach(pinServo_1);
 
  /*initial state no reservation*/
  digitalWrite(led_1_1, LOW);
  digitalWrite(led_1_2, HIGH);


  pinMode(LED, OUTPUT);
  pinMode(Buzzer, OUTPUT);

  /*smart Lightning Setup*/
  pinMode(smart_led1, OUTPUT); //Initialize pin as output.
  pinMode(ldr_1,INPUT);

}

/*Led Reservation*/

void LED_Reservation(char d) 
 {
  /*Slot 1 Reserved*/
  if (d == '1') {
    digitalWrite(led_1_2, HIGH);
    digitalWrite(led_1_1, LOW);
    digitalWrite(LED, LOW);
  }

  /*Slot 1 UnReserved*/
  if (d == '2') {
    digitalWrite(led_1_1, HIGH);
    digitalWrite(led_1_2, LOW);
    digitalWrite(LED, LOW);
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

  
}

void SmartLightnening()
{
    ldrValue_1 = analogRead(ldr_1); //Store the value of the LDR reading in the variable.
 
  //analogWrite(led, ldrValue); //Output this value through PWM.
  if(ldrValue_1 <=300){
    digitalWrite(smart_led1, HIGH);
    //tone(led,1000);
  }
  else{
    digitalWrite(smart_led1, LOW);
    //noTone(led);
  }

  
}

void Counting_Down (int data){

  unsigned long previousMillis = 0;  // variable to store the previous time
  const long interval = 1000;        // interval at which to update the clock (in milliseconds)

  int hours = 0;
  int minutes = 0;
  int seconds = 50;
  lcd.setCursor(0, 1);          // Go to position column 2 & row 1
  lcd.print("Hello Customer");   // Print "Hello, World!"
  
  if (data == '2'){
  while(1){

      //Smoking_sense();

  SmartLightnening();
  unsigned long currentMillis = millis();  // get the current time in milliseconds
  
  // Update the clock display every second
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;
    
        // Display the clock and date on the first row of the LCD screen
    lcd.setCursor(0, 0);
    lcd.print(hours < 10 ? "0" : "");
    lcd.print(hours);
    lcd.print(":");
    lcd.print(minutes < 10 ? "0" : "");
    lcd.print(minutes);
    lcd.print(":");
    lcd.print(seconds < 10 ? "0" : "");
    lcd.print(seconds);
    lcd.print("           ");
    lcd.setCursor(0, 1);


  
    seconds = seconds - 1;

          if(hours == 0 && minutes == 0 && seconds == 0){
      lcd.setCursor(0, 0);
      lcd.print("Time is up     ");
      lcd.setCursor(0, 1);
      lcd.print("See You Soon :)");
      
      digitalWrite(Buzzer, HIGH);
      digitalWrite(LED, HIGH);
      
      delay(10000);
      data=0;
      return;
    }

    if (seconds == 0){
        minutes = minutes-1;
        if(minutes == 0){
          seconds=59;
          continue;
        }
        seconds = 59;
    }
    if(minutes==0 && hours == 0){
      continue;
    }

    if (minutes == 0){
      minutes = 59;
      if(hours == 0)
        continue;
      hours = hours - 1;
      
    }

    


  }
  
  }
  
  }

}

// void Smoking_sensor(){

//     // Check for gas level > 400
//   int value = analogRead(Sensor);

//   if (value > 400) {
//     digitalWrite(LED, HIGH);
//     digitalWrite(Buzzer, HIGH);
//     lcd.setCursor(0, 0);
//     lcd.print("Gas Level :");
//     lcd.print(value);
//     lcd.print("    ");
//     lcd.setCursor(0, 1);
//     lcd.print("GAS Detected!");
//   } else {
//     digitalWrite(LED, LOW);
//     digitalWrite(Buzzer, LOW);
   
//   }

// }




void loop() 
{

  if (Serial.available() > 0)  // checks if any data is received through serial monitor
  {
    data = Serial.read(); /*Reading any receiving data and storing it into variable named data*/
    //for debug
    Serial.print(data);  //displaying the data
    Serial.print("\n");  //adding space by giving a New line
  }

  LED_Reservation(data);

  Servo_parking(data);

  Counting_Down (data);

  //Smoking_sensor();

  SmartLightnening();

}
