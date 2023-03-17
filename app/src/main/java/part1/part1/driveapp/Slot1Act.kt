package part1.part1.driveapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Slot1Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot1)

        val time_12_4 = findViewById<TextView>(R.id.slot_1_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_1_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_1_3_btn_txt)


        val done = findViewById<TextView>(R.id.Done_1_btn_txt)

        time_12_4.setOnClickListener {

            time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))
            val url =
                "http://192.168.1.5/slot_select.php?slotnum=1&available=1'"

            val rq: RequestQueue = Volley.newRequestQueue(this)

            val sr= StringRequest(Request.Method.GET,url, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {
                       Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq.add(sr)


        }
        time_4_8.setOnClickListener {

            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

            val url =
                "http://192.168.1.5/slot_select.php?slotnum=12&available=1"

            val rq: RequestQueue = Volley.newRequestQueue(this)

            val sr= StringRequest(Request.Method.GET,url, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {
                    Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq.add(sr)

        }
        time_8_12.setOnClickListener {

            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

        }



        done.setOnClickListener{

            //    if(1) {
            //     slot1_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
            //     Toast.makeText(this, "Slot 1 is reserved", Toast.LENGTH_LONG).show()
            // }
            //    else
            //       Toast.makeText(this, "Failed::Slot 1 is already reserved", Toast.LENGTH_LONG).show()


            val i= Intent(this,CheckOutAct::class.java)
            startActivity(i)
        }

    }
}