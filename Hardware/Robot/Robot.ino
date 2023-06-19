#include <ArduinoBlue.h>


//slot pins
#define s1 A1
#define s2 A2
#define s3 A3
#define s4 A4

//Moving motor and Ir sensor pins
#define enA 10   //Enable1 L298 Pin enA
#define enB 5    //Enable2 L298 Pin enB
#define in1 9    //Motor1  L298 Pin in1
#define in2 8    //Motor1  L298 Pin in2
#define in3 7    //Motor2  L298 Pin in3
#define in4 6    //Motor2  L298 Pin in4
#define buzin 2  //buzzer input pin
const int x = 80;
const int Delay = 350;
int stop = 1;
int back = 1;
// US sensor pins
#define s5 A5
#define s6 A0
//#define s7 0
//#define s8 1
const int TRIG_PIN = s5;       // Arduino pin connected to Ultrasonic Sensor's TRIG pin
const int ECHO_PIN = s6;       // Arduino pin connected to Ultrasonic Sensor's ECHO pin
const int TRIG_PIN_back = s3;  // Arduino pin connected to Ultrasonic Sensor's TRIG pin in back ////////////////////////////////
const int ECHO_PIN_back = s4;  // Arduino pin connected to Ultrasonic Sensor's ECHO pin in back //////////////////////////////////

const int BUZZER_PIN = buzin;

const int DISTANCE_THRESHOLD = 15;  // centimeters
// variables will change:
float duration_us, distance_cm, duration_us_back,distance_cm_back;
//const int TRIG_PIN_back   = A4; // Arduino pin connected to Ultrasonic Sensor's TRIG pin in back
//const int ECHO_PIN_back   = A3; // Arduino pin connected to Ultrasonic Sensor's ECHO pin in back
//********************
int Button_reading = -1;
int slot_reading = -1;       //nouran
int slot_reading_back = -1;  //nouran
//***************
#define IRS_L 3  //ir sensor Right
#define IRS_R 4  //ir sensor Left

int r_state;
int l_state;
//bool delayRunningForward = false;
//bool delayRunningBackward = false;
#define IRS_Back_L 11  //ir sensor right
#define IRS_Back_R 12  //ir sensor Left

int r_back_state;
int l_back_state;

void turnLeft() {           //turnLeft
  analogWrite(enA, x);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in2, HIGH);  //Right Motor forward Pin
  digitalWrite(in1, LOW);   //Right Motor backword Pin
  digitalWrite(in4, LOW);   //Left Motor backword Pin
  digitalWrite(in3, LOW);   //Left Motor forward Pin
}

const void forward() {      //forward -------------->>>>>CHECKKK
  analogWrite(enA, x);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in2, HIGH);  //Right Motor forward Pin
  digitalWrite(in1, LOW);   //Right Motor backword Pin
  digitalWrite(in4, LOW);   //Left Motor backword Pin  <----------------------
  digitalWrite(in3, HIGH);  //Left Motor forward Pin
}

const void Back() {         //forward -------------->>>>>CHECKKK
  analogWrite(enA, x);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in1, HIGH);  //Right Motor forward Pin
  digitalWrite(in2, LOW);   //Right Motor backword Pin
  digitalWrite(in3, LOW);   //Left Motor backword Pin  <----------------------
  digitalWrite(in4, HIGH);  //Left Motor forward Pin
}

void turnRight() {          //turnRight
  analogWrite(enA, x);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in2, LOW);   //Right Motor forward Pin
  digitalWrite(in1, LOW);   //Right Motor backword Pin
  digitalWrite(in4, LOW);   //Left Motor backword Pin
  digitalWrite(in3, HIGH);  //Left Motor forward Pin
}

void turn_BACK_Left() {     //turnBackLeft
  analogWrite(enA, x-50);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x-50);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in2, LOW);   //Right Motor forward Pin
  digitalWrite(in1, HIGH);  //Right Motor backword Pin
  digitalWrite(in4, LOW);   //Left Motor backword Pin
  digitalWrite(in3, LOW);   //Left Motor forward Pin
}
void turn_BACK_Right() {    //turnBackLeft
  analogWrite(enA, x-50);      // Write The Duty Cycle 0 to 255 Enable Pin A for Motor1 Speed (Right Motors)
  analogWrite(enB, x-50);      // Write The Duty Cycle 0 to 255 Enable Pin B for Motor2 Speed (Left Motors)
  digitalWrite(in2, LOW);   //Right Motor forward Pin
  digitalWrite(in1, LOW);   //Right Motor backword Pin
  digitalWrite(in4, HIGH);  //Left Motor backword Pin
  digitalWrite(in3, LOW);   //Left Motor forward Pin
}
void Stop() {              //stop
  digitalWrite(in1, LOW);  //Right Motor forward Pin
  digitalWrite(in2, LOW);  //Right Motor backword Pin
  digitalWrite(in3, LOW);  //Left Motor backword Pin
  digitalWrite(in4, LOW);  //Left Motor forward Pin
}

void forward_objectDetection() {
  // generate 10-microsecond pulse to TRIG pin
  digitalWrite(TRIG_PIN, HIGH);
  delay(10);
  digitalWrite(TRIG_PIN, LOW);

  // measure duration of pulse from ECHO pin
  duration_us = pulseIn(ECHO_PIN, HIGH);
  // calculate the distance
  distance_cm = 0.017 * duration_us;

  if (distance_cm < DISTANCE_THRESHOLD) {
    digitalWrite(BUZZER_PIN, HIGH);  // turn on Piezo Buzzer
    Stop();
    delay(100);
  } else
    digitalWrite(BUZZER_PIN, LOW);  // turn off Piezo Buzzer

  // print the value to Serial Monitor
  /* Serial.print("distance: ");
  Serial.print(distance_cm);
  Serial.println(" cm");
  delay(500);*/
}
void Backward_objectDetection() {
  // generate 10-microsecond pulse to TRIG pin
  digitalWrite(TRIG_PIN_back, HIGH);
  delay(10);
  digitalWrite(TRIG_PIN_back, LOW);

  // measure duration of pulse from ECHO pin
  duration_us_back = pulseIn(ECHO_PIN_back, HIGH);
  // calculate the distance
  distance_cm_back = 0.017 * duration_us_back;

  if (distance_cm_back < DISTANCE_THRESHOLD) {
    digitalWrite(BUZZER_PIN, HIGH);  // turn on Piezo Buzzer
    Stop();
    delay(100);
  } else
    digitalWrite(BUZZER_PIN, LOW);  // turn off Piezo Buzzer
}

void setup() {

  Serial.begin(9600);
  //keypad
  pinMode(s1, INPUT_PULLUP);  // set pin as input
  pinMode(s2, INPUT_PULLUP);  // set pin as input
 // pinMode(s3, INPUT_PULLUP);  // set pin as input
 // pinMode(s4, INPUT_PULLUP);  // set pin as input

  // put your setup code here, to run once:

  pinMode(IRS_R, INPUT);  // declare ir Forward sensor as input
  pinMode(IRS_L, INPUT);  // declare ir Forward sensor as input

  // BACK sensors
  pinMode(IRS_Back_R, INPUT);  // declare ir Back sensor as input
  pinMode(IRS_Back_L, INPUT);  // declare ir Back sensor as input

  pinMode(enA, OUTPUT);  // declare as output for L298 Pin enA
  pinMode(in1, OUTPUT);  // declare as output for L298 Pin in1
  pinMode(in2, OUTPUT);  // declare as output for L298 Pin in2
  pinMode(in3, OUTPUT);  // declare as output for L298 Pin in3
  pinMode(in4, OUTPUT);  // declare as output for L298 Pin in4
  pinMode(enB, OUTPUT);  // declare as output for L298 Pin enB


  pinMode(TRIG_PIN, OUTPUT);  // set arduino pin to output mode
  pinMode(ECHO_PIN, INPUT);   // set arduino pin to input mode
                              //pinMode(TRIG_PIN_back, OUTPUT);   // set arduino pin to output mode
  pinMode(s3, OUTPUT);  //pinMode(ECHO_PIN_back, INPUT); 
  pinMode(s4, INPUT);      // set arduino pin to input mode

  pinMode(BUZZER_PIN, OUTPUT);  // set arduino pin to output mode

#define TRUE 1
#define FALSE 0

  bool move = 0;
}

bool going = 1;

void read_IR_Sensors() {
  r_state = digitalRead(IRS_R);  // the reading of the right sensor
  l_state = digitalRead(IRS_L);  // the reading of the left sensor
}

void read_Back_IR_Sensors() {
  r_back_state = digitalRead(IRS_Back_R);  // the reading of the right sensor
  l_back_state = digitalRead(IRS_Back_L);  // the reading of the left sensor
}

int Read_keypad() {
  while (1) {
    if (!digitalRead(s1)) {
      return 1;  /////////to count the number of black lines on the physical ground
    }
    if (!digitalRead(s2)) {
      return 2;  /////////to be more relavent count the number of black lines on the physical ground
    }
    //if (!digitalRead(s3)) {
     // return 3;  /////////to be more relavent count the number of black lines on the physical ground
    //}
    //if (!digitalRead(s4)) {
    //  return 4;  /////////to be more relavent count the number of black lines on the physical ground
    //}
  }
}

//const int read_key_intial = 1;
void loop() {

  slot_reading = Read_keypad();
  slot_reading_back = slot_reading;
  delay(3000);

  while (1) {
     
    // Backward_objectDetection();
    //
    if (going == 1 && slot_reading != -1) {  //8ayerha mn == -1 to != -1
forward_objectDetection();
      read_IR_Sensors();

      if ((l_state == LOW && r_state == LOW)) {
        forward();
      } else if ((l_state == HIGH && r_state == LOW)) {
        turnLeft();
      } else if ((l_state == LOW && r_state == HIGH)) {

        turnRight();
      }

      else if (l_state == HIGH && r_state == HIGH) {
        if (slot_reading == 1 && stop == 1) {
          delay(50);
          Stop();
          delay(5000);
          going = 0;
          stop = 0;
        }

        else if (slot_reading != 1 && stop == 1) {
          slot_reading--;
          delay(150);
          continue;
        }
      }
    }
    // delayRunningBackward = TRUE;
    //delayRunningForward = FALSE;

   
    if (going == 0 && slot_reading_back != -1) {
      Backward_objectDetection();
      read_Back_IR_Sensors();
      if ((l_back_state == LOW && r_back_state == LOW)) {
        Back();
      } else if ((l_back_state == HIGH && r_back_state == LOW)) {
        turn_BACK_Left();
      } else if ((l_back_state == LOW && r_back_state == HIGH)) {

        turn_BACK_Right();
      } else if (l_back_state == HIGH && r_back_state == HIGH) {
        if (slot_reading_back == 1 && back == 1) {
          Stop();
          delay(5000);
          going = 1;
          back = 0;
          slot_reading_back = -1;
          slot_reading = -1;
        }

        else if (slot_reading_back != 1 && back == 1) {
          slot_reading_back--;
          delay(150);
          continue;
        }
      }
    }
  }
}
