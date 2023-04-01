package part1.part1.driveapp

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

class Slot3Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot3)


        val time_12_4 = findViewById<TextView>(R.id.slot_3_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_3_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_3_3_btn_txt)


        time_12_4.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=31"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=31"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

                    time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=31&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)



        }
        time_4_8.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=32"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=32"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

                    time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=32&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)



        }
        time_8_12.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=33"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=33"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_8_12.setBackgroundColor(Color.parseColor("#CC0000"))
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

                    time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=33&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
                            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }

        val done = findViewById<TextView>(R.id.Done_3_btn_txt)

        done.setOnClickListener {
            if (GlobalVar.Status == 1) {
                GlobalVar.enable_status_button = 1
                val j = Intent(this, CheckOutAct::class.java)
                startActivity(j)
            } else
                Toast.makeText(this, "No Chosen Slot", Toast.LENGTH_LONG).show()
        }
    }
}