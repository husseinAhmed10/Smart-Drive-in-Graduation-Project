package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class TotalAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        var url=GlobalVar.url_ip + "/get_total.php?bill_no=" +intent.getStringExtra("bno")
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, { response ->
            var totalbill=findViewById<TextView>(R.id.total_tv)
            totalbill.text=response
            GlobalVar.amount=totalbill.text.toString().toInt()
        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })


        rq.add(sr)

        GlobalVar.done_ordering = 1
        val i= Intent(this,Points::class.java)
        startActivity(i)
    }
}