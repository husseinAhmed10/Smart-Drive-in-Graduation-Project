package part1.part1.driveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Credit_CardAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)


        var totalPoints=0               //points got from buying


        val button_card=findViewById<Button>(R.id.visa_button)
        val card_no=findViewById<EditText>(R.id.card_number)
        val card_no1=findViewById<EditText>(R.id.card_number1)
        val card_no2=findViewById<EditText>(R.id.card_number2)

        var Total_card_No="" //Card Number
        val Empty_msg="Failed,Please Filled all Labels correctly"
        val correct_msg="Successfully payment,We wait you"
        var Label_1="a"
        var Label_2="aa"
        var Label_3="aaa"
        val extras = intent.extras
        if (extras != null) {
            totalPoints = extras.getInt("totalPoints", 0) // default value is 0
        }


        button_card.setOnClickListener {
            Label_1=card_no.text.toString();
            Label_2=card_no1.text.toString();
            Label_3=card_no2.text.toString();
            Total_card_No=Label_1+Label_2+Label_3;
            when(Total_card_No)
            {
                "123456789999" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for sucessful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "565651111666" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for sucessful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "987654321111" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "246810121416" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "987654321987" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "135791113151" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "369121518212" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "112233445566" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "987654321234" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "234567891011" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "876543219876" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                "989898989898" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }

                "454545454545" ->{
                    Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                    //Push Totalpoints in database for successful Payment
                    card_no.text.clear()
                    card_no1.text.clear()
                    card_no2.text.clear()
                }
                else -> Toast.makeText(this, Empty_msg, Toast.LENGTH_SHORT).show()
            }
        }




    }
}