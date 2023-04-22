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
            //total_points.text=response
            val regex = Regex("\\d+")
            val matchResult = regex.find(response)
            val number = matchResult?.value?.toInt()

            if (number != null) {
                // Use the integer value here
                GlobalVar.points= number
                total_points.text=GlobalVar.points.toString()
            }


        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })

        rq.add(sr)
        val i= Intent(this,CheckOutAct::class.java)
        startActivity(i)
    }
}