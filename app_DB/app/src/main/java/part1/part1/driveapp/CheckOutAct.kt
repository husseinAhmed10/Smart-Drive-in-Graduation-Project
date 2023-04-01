package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class CheckOutAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        //
        var currentPoints: Int?= GlobalVar.points  //my points
        var totalPoints: Int?=0               //points got from buying
        //
        var orderAmount: Int?= GlobalVar.order_points // this is the order money
        var pointsToAdd = (orderAmount.toString().toInt() * 0.1).toInt()
        totalPoints = currentPoints.toString().toInt() + pointsToAdd.toString().toInt()

        var orderTextView = findViewById<TextView>(R.id.textView_order)//credit
        orderTextView.text = "Your Order: $orderAmount"

        var pointsTextView = findViewById<TextView>(R.id.textView2_points)
        pointsTextView.text = "Your Point L.E: $currentPoints"

        var button_payment = findViewById<TextView>(R.id.button3)//button3 for payment by credit
      //  button_payment.isEnabled = totalPoints < orderAmount

        var buttonPoints = findViewById<TextView>(R.id.button5)
      //  buttonPoints.isEnabled = totalPoints >= orderAmount


        button_payment.setOnClickListener {
            var intent = Intent(this, Credit_CardAct::class.java)
            intent.putExtra("totalPoints", totalPoints)
            startActivity(intent)
        }

        buttonPoints.setOnClickListener {
            var money = totalPoints.toString().toInt() - orderAmount.toString().toInt()

            pointsTextView.text = "Your Point L.E: $currentPoints"
            buttonPoints.isEnabled =false
            Toast.makeText(this, "Successfully Payment", Toast.LENGTH_SHORT).show()
            GlobalVar.points = money
            // Push the currentPoints to database as zero
            val url = GlobalVar.url_ip + "/update_points.php?points="+money+"&name=" + userLoginInfo

            val rq: RequestQueue = Volley.newRequestQueue(this)

            val sr= StringRequest(Request.Method.GET,url, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"fail in check out", Toast.LENGTH_LONG).show()
                else {

                    GlobalVar.points = money

                      //  val i= Intent(this,StatusAct::class.java)
                      //  startActivity(i)
                    Toast.makeText(this, "Payement Complete", Toast.LENGTH_LONG).show()
                }

            }, {
                    error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq.add(sr)

            val i= Intent(this,StatusAct::class.java)
            startActivity(i)

        }
            //
           // GlobalVar.Status = 1
           // var intent = Intent(this, DriveInActivity::class.java)
           // startActivity(intent)



        }

    }
