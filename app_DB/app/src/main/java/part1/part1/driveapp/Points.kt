package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Points : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_points)

        var url=GlobalVar.url_ip + "/pointssss.php?name=" + userLoginInfo.name
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, { response ->
            var total_points=findViewById<TextView>(R.id.totalpts)
            val regex = Regex("\\d+")
            val matchResult = regex.find(response)
            val number = matchResult?.value?.toInt()

            if (number != null) {
                // Use the integer value here
                GlobalVar.points= number
                total_points.text = "Remaining Points: ${GlobalVar.points.toString()}"

            }

            if (GlobalVar.point_btn == 1){
                GlobalVar.point_btn = 0     //only show points
            }

            else if(GlobalVar.done_reserve == 1 || GlobalVar.drivethru_choice == 1){    //after reserve a slot
                GlobalVar.done_reserve = 0
                val i = Intent(this, CheckOutAct::class.java)   //go to check out
                startActivity(i)
            }
            else if(GlobalVar.done_ordering == 1){      //after ordering from menu



                GlobalVar.done_ordering = 0
                val i = Intent(this, CheckOutAct::class.java)   //go to check out
                startActivity(i)

            }

            else if (GlobalVar.reserved == 1 && GlobalVar.point_btn == 0) {     //go status act
                val i = Intent(this, StatusAct::class.java)
                startActivity(i)
            }




        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })

        rq.add(sr)

    }
}