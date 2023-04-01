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
import part1.part1.driveapp.userLoginInfo.Companion.name

class Slot1Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot1)

        val time_12_4 = findViewById<TextView>(R.id.slot_1_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_1_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_1_3_btn_txt)


        val done = findViewById<TextView>(R.id.Done_1_btn_txt)





        time_12_4.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=11"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=11"

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



                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=11&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
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

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }
        time_4_8.setOnClickListener {

            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=12"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=12"
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

                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=12&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
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

                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


            /////////////////




        }
        time_8_12.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select.php?slotnum=13"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum=13"


                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()

                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=13&name="+ userLoginInfo.name
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