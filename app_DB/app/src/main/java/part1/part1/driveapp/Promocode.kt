package part1.part1.driveapp

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import part1.part1.driveapp.GlobalVar.Companion.points
import part1.part1.driveapp.GlobalVar.Companion.promo

class Promocode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promocode)

        val editTextPromoCode = findViewById<EditText>(R.id.editText_promocode)
        val buttonSubmit = findViewById<Button>(R.id.button_submit)
        val textViewRemainingUsage = findViewById<TextView>(R.id.textView_remaining_usage)

        //TODO: retrieve rem number of usages of promocode from database
        var url=GlobalVar.url_ip + "/promocode.php?name=" + userLoginInfo.name
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, { response ->

            val regex = Regex("\\d+")
            val matchResult = regex.find(response)
            val number = matchResult?.value?.toInt()

            if (number != null) {
                // Use the integer value here
                promo = number
                textViewRemainingUsage.text = "Remaining Usage: $promo"
            }

        buttonSubmit.setOnClickListener {
            val promoCode = editTextPromoCode.text.toString().trim()

            if (promoCode == "three30") {
                if (promo!! > 0) {
                    showSuccessDialog()
                    promo = promo!! - 1
                    textViewRemainingUsage.text = "Remaining Usage: $promo"
                    // TODO: Update the user's points in the database by adding 30
                    points= points?.plus(30)
                    var url1=GlobalVar.url_ip + "/updatepromo.php?promocode=" + promo+"&name=" +userLoginInfo.name
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
                    var url2=GlobalVar.url_ip + "/AddNewPoints.php?points=" + points+"&name=" +userLoginInfo.name
                    var rq2: RequestQueue = Volley.newRequestQueue(this)
                    var sr2= StringRequest(Request.Method.GET,url2, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
                        else{

                        }

                    }, { error ->
                        Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                    })

                    rq2.add(sr2)



                } else {
                    showMaxLimitDialog()
                }
            } else {
                showErrorDialog()
            }
        } }, { error ->
        Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
    })

    rq.add(sr)


}

    private fun showSuccessDialog() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Congratulations!")
            .setMessage("You win 30 points!")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss()
                val i= Intent(this,CheckOutAct::class.java)
                startActivity(i)}
            .create()

        dialog.show()
    }

    private fun showMaxLimitDialog() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Sorry!")
            .setMessage("You have reached the maximum limit of using this promocode.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss()
               }
            .create()

        dialog.show()
    }

    private fun showErrorDialog() {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("Invalid promocode. Please try again.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss()
        }
            .create()

        dialog.show()
    }}