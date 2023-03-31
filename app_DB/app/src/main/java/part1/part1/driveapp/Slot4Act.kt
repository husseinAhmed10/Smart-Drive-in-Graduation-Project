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

class Slot4Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot4)


        val time_12_4 = findViewById<TextView>(R.id.slot_4_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_4_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_4_3_btn_txt)

        time_12_4.setOnClickListener {


            val url2 = "http://192.168.1.8/slot_select.php?slotnum=41"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = "http://192.168.1.8/update_availablity.php?slotnum=41"
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

                    val url = "http://192.168.1.8/spot_update.php?Spot=41&name="+ userLoginInfo.name
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


            val url2 = "http://192.168.1.8/slot_select.php?slotnum=42"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = "http://192.168.1.8/update_availablity.php?slotnum=42"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
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

                    rq3.add(sr3)

                    time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

                    val url = "http://192.168.1.8/spot_update.php?Spot=42&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
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

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)



        }
        time_8_12.setOnClickListener {


            val url2 = "http://192.168.1.8/slot_select.php?slotnum=43"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = "http://192.168.1.8/update_availablity.php?slotnum=43"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
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

                    rq3.add(sr3)


                    val url = "http://192.168.1.8/spot_update.php?Spot=43&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
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

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }

        val done = findViewById<TextView>(R.id.Done_4_btn_txt)

        done.setOnClickListener{

            if (GlobalVar.Status == 1){
                val i= Intent(this,CheckOutAct::class.java)
                startActivity(i)
            }
            else
                Toast.makeText(this, "No Chosen Slot", Toast.LENGTH_LONG).show()


        }

    }
}