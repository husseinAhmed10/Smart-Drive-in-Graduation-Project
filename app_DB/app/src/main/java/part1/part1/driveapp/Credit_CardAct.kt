package part1.part1.driveapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Credit_CardAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)
        //TODO: retrieve credit card  from database

        var urlf=GlobalVar.url_ip + "/getcredit.php?name=" + userLoginInfo.name
        var rqf: RequestQueue = Volley.newRequestQueue(this)
        var srf= StringRequest(Request.Method.GET,urlf, { response ->

            val regex = Regex("\\d+")
            val matchResult = regex.find(response)
            val number = matchResult?.value?.toInt()

            if (number != null) {
                // Use the long value here
                GlobalVar.creditcard = number


            }



        var totalPoints=0               //points got from buying

        val button_card=findViewById<Button>(R.id.visa_button)
        val card_no=findViewById<EditText>(R.id.card_number)
        val card_no1=findViewById<EditText>(R.id.card_number1)
        val card_no2=findViewById<EditText>(R.id.card_number2)


         //Card Number
        val Empty_msg="Failed, Please Fill with Correct Information"
        val correct_msg="Successful Payment, Thank you"
        var Label_1="a"
        var Label_2="aa"
        var Label_3="aaa"
        val extras = intent.extras
        if (extras != null) {
            totalPoints = extras.getInt("totalPoints", 0) // default value is 0
        //GlobalVar.creditcard = extras.getInt("GlobalVar.creditcard", -1)
        }


        if (GlobalVar.creditcard != 0) {
            var creditCardNumber = GlobalVar.creditcard.toString()
            Label_1 = creditCardNumber.substring(0, 4)
            Label_2 = creditCardNumber.substring(4, 7)
            Label_3 = creditCardNumber.substring(7, 10)




            // Set the EditText fields to the extracted values
            card_no.setText(Label_1)
            card_no1.setText(Label_2)
            card_no2.setText(Label_3)

        } else {
            // Handle the case when Getcreditcard is 0
            card_no.text.clear()
            card_no1.text.clear()
            card_no2.text.clear()
        }

        button_card.setOnClickListener {
            Label_1 = card_no.text.toString()
            Label_2 = card_no1.text.toString()
            Label_3 = card_no2.text.toString()
            GlobalVar.Total_card_No = Label_1 + Label_2 + Label_3

            when (GlobalVar.Total_card_No) {
                "1234567899", "5656511116", "9876543211", "2468101214",
                "9876543219", "1357911131", "3691215182", "1122334455",
                "9876543212", "2345678910", "8765432198", "9898989898",
                "4545454545" -> {
                    if (GlobalVar.creditcard == 0) {
                        showSaveDialog()
                    }
                    else {


                        Toast.makeText(this, correct_msg, Toast.LENGTH_SHORT).show()
                        card_no.text.clear()
                        card_no1.text.clear()
                        card_no2.text.clear()
                        GlobalVar.driveinmenu=1
                        val i= Intent(this,StatusAct::class.java)
                        startActivity(i)
                    }
                }

                else -> Toast.makeText(this, Empty_msg, Toast.LENGTH_SHORT).show()
            }

        }
        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rqf.add(srf)


    }

    // Move the function outside the onCreate() function
    fun showSaveDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Save Credit card")
            .setMessage("Do you want to save Your credit Card?")
            .setPositiveButton("Yes") { _, _ ->
                // TODO: Handle save payment logic
                GlobalVar.creditcard=GlobalVar.Total_card_No.toInt()
                var url1=GlobalVar.url_ip + "/updatecredit.php?credit=" + GlobalVar.creditcard +"&name=" +userLoginInfo.name
                var rq1: RequestQueue = Volley.newRequestQueue(this)
                var sr1= StringRequest(Request.Method.GET,url1, { response ->
                    if(response.equals("0"))
                        Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
                    else{

                    }

                }, { error ->
                    Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                })
                rq1.add(sr1)
                Toast.makeText(this, "Credit Saved!", Toast.LENGTH_SHORT).show()
                val i= Intent(this,StatusAct::class.java)
                startActivity(i)
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "Credit not Saved", Toast.LENGTH_SHORT).show()
            }
            .setCancelable(false)
            .create()
            .show()
    }
}