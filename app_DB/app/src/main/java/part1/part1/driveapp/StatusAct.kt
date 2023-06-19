package part1.part1.driveapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class StatusAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        val client_name = findViewById<TextView>(R.id.Text_name)
        client_name.text = userLoginInfo.name

        val client_points = findViewById<TextView>(R.id.Text_points)
        client_points.text= "Your Points: ${GlobalVar.points.toString()}"

        //add order details
        val order_detail = findViewById<TextView>(R.id.Text_order)
        val logout=findViewById<TextView>(R.id.logout)

        order_detail.setOnClickListener {

            var i= Intent(this,OrderAct::class.java)
            startActivity(i)

        }
        val order_home = findViewById<TextView>(R.id.text_home)


        order_home.setOnClickListener {

            var i= Intent(this,HomeAct::class.java)
            startActivity(i)

        }

        //if arrived, in database arrived
        val arrived_btn = findViewById<TextView>(R.id.Text_Arrived)

        arrived_btn.visibility = if (GlobalVar.drivethru_choice == 0) View.VISIBLE
        else View.INVISIBLE

        arrived_btn.setOnClickListener{
            GlobalVar.reserved=0

            val urlz = GlobalVar.url_ip + "/updateres.php?name="+ userLoginInfo.name

            val rqz: RequestQueue = Volley.newRequestQueue(this)

            val srz= StringRequest(Request.Method.GET,urlz, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"You already arrived", Toast.LENGTH_LONG).show()
                else {
                    Toast.makeText(this, "Arrived Safely Welcome", Toast.LENGTH_LONG).show()
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
            })

            rqz.add(srz)
            val url3 = GlobalVar.url_ip + "/update_arrive.php?name="+ userLoginInfo.name

            val rq3: RequestQueue = Volley.newRequestQueue(this)

            val sr3= StringRequest(Request.Method.GET,url3, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"You already arrived", Toast.LENGTH_LONG).show()
                else {
                    Toast.makeText(this, "Arrived Safely Welcome", Toast.LENGTH_LONG).show()
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
            })

            rq3.add(sr3)
            var i= Intent(this,HomeAct::class.java)
            startActivity(i)
        }
            logout.setOnClickListener{

                val i= Intent(this,MainActivity::class.java)
                startActivity(i)
            }
    }
}