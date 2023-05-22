#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);

#define LED 2
#define Buzzer 3
#define Sensor A3

unsigned long previousMillis = 0;  // variable to store the previous time
const long interval = 1000;        // interval at which to update the clock (in milliseconds)

/*Smart lightneing Pins*/
//Declare a variable used later in the program.
#define ldr_1 A0
#define smart_led1 7 //A3
#define ldr_2 A1
#define smart_led2 8 //A4
#define ldr_3 A2
#define smart_led3 9//A5
 
int ldrValue_1; //Declare variable of type (int) and name (ldrValue)
int ldrValue_2; //Declare variable of type (int) and name (ldrValue)
int ldrValue_3; //Declare variable of type (int) and name (ldrValue)
/*------------------------------*/
void SmartLightnening()
{
    ldrValue_1 = analogRead(smart_led1); //Store the value of the LDR reading in the variable.
 ldrValue_2 = analogRead(smart_led2); //Store the value of the LDR reading in the variable.
 ldrValue_3 = analogRead(smart_led3); //Store the value of the LDR reading in the variable.
 
  //analogWrite(led, ldrValue); //Output this value through PWM.
  if(ldrValue_1 <=10){
    digitalWrite(smart_led1, HIGH);
    //tone(led,1000);
  }
  else{
    digitalWrite(smart_led1, LOW);
    //noTone(led);
  }

  if(ldrValue_2 <=10){
    digitalWrite(smart_led2, HIGH);
    //tone(led,1000);
  }
  else{
    digitalWrite(smart_led2, LOW);
    //noTone(led);
  }

  if(ldrValue_3 <=10){
    digitalWrite(smart_led3, HIGH);
    //tone(led,1000);
  }
  else{
    digitalWrite(smart_led3, LOW);
    //noTone(led);
  }
}


void setup() {
  Serial.begin(9600);
  lcd.init();
  lcd.backlight();
  pinMode(LED, OUTPUT);
  pinMode(Buzzer, OUTPUT);

  /*smart Lightning Setup*/
  pinMode(smart_led1, OUTPUT); //Initialize pin as output.
  pinMode(ldr_1,INPUT);
  pinMode(smart_led2, OUTPUT); //Initialize pin as output.
  pinMode(ldr_2,INPUT);
  pinMode(smart_led3, OUTPUT); //Initialize pin as output.
  pinMode(ldr_3,INPUT);
}

void loop() {

  SmartLightnening();

  unsigned long millisSinceMidnight = (6 * 3600 + 30 * 60 + 60) * 1000;

  unsigned long currentMillis = millis();  // get the current time in milliseconds
  
  // Update the clock display every second
  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;
    
    // Get current time and date
    unsigned long millisSinceStart =   currentMillis- millisSinceMidnight ;
    int hours = (millisSinceStart / 3600000) % 24;
    int minutes = (millisSinceStart / 60000) % 60;
    int seconds = (millisSinceStart / 1000) % 60;
    int day = 3;
    int month = 5;
    int year = 2023;
    
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
    lcd.print(day < 10 ? "0" : "");
    lcd.print(day);
    lcd.print("/");
    lcd.print(month < 10 ? "0" : "");
    lcd.print(month);
    lcd.print("/");
    lcd.print(year);
    lcd.print("    ");
  }
  
  // Check for gas level > 400
  int value = analogRead(Sensor);
  
 
  
  if (value > 400) {
    digitalWrite(LED, HIGH);
    digitalWrite(Buzzer, HIGH);
    lcd.setCursor(0, 0);
    lcd.print("Gas Level :");
    lcd.print(value);
    lcd.print("    ");
    lcd.setCursor(0, 1);
    lcd.print("GAS Detected!");
  } else {
    digitalWrite(LED, LOW);
    digitalWrite(Buzzer, LOW);
   
  }
}
