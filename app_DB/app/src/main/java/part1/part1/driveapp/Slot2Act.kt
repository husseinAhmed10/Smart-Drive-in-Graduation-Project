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



class Slot2Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot2)

        val time_12_4 = findViewById<TextView>(R.id.slot_2_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_2_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_2_3_btn_txt)

        val time_12_4_s4 = findViewById<TextView>(R.id.slot_2_4_btn_txt)
        val time_4_8_s5 = findViewById<TextView>(R.id.slot_2_5_btn_txt)
        val time_8_12_s6 = findViewById<TextView>(R.id.slot_2_6_btn_txt)



        //************************** Temp check

        //
        val urlt1 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=21"

        val rqt1: RequestQueue = Volley.newRequestQueue(this)

        val srt1= StringRequest(Request.Method.GET,urlt1, { response ->
            if(response.equals("1"))
                time_12_4.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{
                //
                val urlv1 = GlobalVar.url_ip + "/slot_select.php?slotnum=21"

                val rqv1: RequestQueue = Volley.newRequestQueue(this)

                val srv1= StringRequest(Request.Method.GET,urlv1, { response ->
                    if(response.equals("0"))
                        time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv1.add(srv1)

//
            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt1.add(srt1)

        //*******

        val urlt2 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=22"

        val rqt2: RequestQueue = Volley.newRequestQueue(this)

        val srt2= StringRequest(Request.Method.GET,urlt2, { response ->
            if(response.equals("1"))
                time_4_8.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{

                //*******

                val urlv2 = GlobalVar.url_ip + "/slot_select.php?slotnum=22"

                val rqv2: RequestQueue = Volley.newRequestQueue(this)

                val srv2= StringRequest(Request.Method.GET,urlv2, { response ->
                    if(response.equals("0"))
                        time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv2.add(srv2)

                //*******

            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt2.add(srt2)

        //*******

        val urlt3 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=23"

        val rqt3: RequestQueue = Volley.newRequestQueue(this)

        val srt3= StringRequest(Request.Method.GET,urlt3, { response ->
            if(response.equals("1"))
                time_8_12.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{
                val urlv3 = GlobalVar.url_ip + "/slot_select.php?slotnum=23"

                val rqv3: RequestQueue = Volley.newRequestQueue(this)

                val srv3= StringRequest(Request.Method.GET,urlv3, { response ->
                    if(response.equals("0"))
                        time_8_12.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv3.add(srv3)

                //*******
            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt3.add(srt3)

        //*******

        val urlt4 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=24"

        val rqt4: RequestQueue = Volley.newRequestQueue(this)

        val srt4= StringRequest(Request.Method.GET,urlt4, { response ->
            if(response.equals("1"))
                time_12_4_s4.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{
                //***
                val urlv4 = GlobalVar.url_ip + "/slot_select.php?slotnum=24"

                val rqv4: RequestQueue = Volley.newRequestQueue(this)

                val srv4= StringRequest(Request.Method.GET,urlv4, { response ->
                    if(response.equals("0"))
                        time_12_4_s4.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv4.add(srv4)
                //****
            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt4.add(srt4)

        //*******

        val urlt5 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=25"

        val rqt5: RequestQueue = Volley.newRequestQueue(this)

        val srt5= StringRequest(Request.Method.GET,urlt5, { response ->
            if(response.equals("1"))
                time_4_8_s5.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{
                //*******

                val urlv5 = GlobalVar.url_ip + "/slot_select.php?slotnum=25"

                val rqv5: RequestQueue = Volley.newRequestQueue(this)

                val srv5= StringRequest(Request.Method.GET,urlv5, { response ->
                    if(response.equals("0"))
                        time_4_8_s5.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv5.add(srv5)

                //*******
            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt5.add(srt5)

        //*******

        val urlt6 = GlobalVar.url_ip + "/slot_select_temp.php?slotnum=26"

        val rqt6: RequestQueue = Volley.newRequestQueue(this)

        val srt6= StringRequest(Request.Method.GET,urlt6, { response ->
            if(response.equals("1"))
                time_8_12_s6.setBackgroundColor(Color.parseColor("#ff0000ff"))
            else{
                val urlv6 = GlobalVar.url_ip + "/slot_select.php?slotnum=26"

                val rqv6: RequestQueue = Volley.newRequestQueue(this)

                val srv6= StringRequest(Request.Method.GET,urlv6, { response ->
                    if(response.equals("0"))
                        time_8_12_s6.setBackgroundColor(Color.parseColor("#CC0000"))
                }, { error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rqv6.add(srv6)
            }
        }, { error ->
            Log.e("Error", error.message.toString())
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rqt6.add(srt6)

//



//


//





        time_12_4.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=21"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=21"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_12_4.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 21
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)



//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=11&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }
        time_4_8.setOnClickListener {

            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=22"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=22"
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_4_8.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 22
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=12&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


            /////////////////




        }
        time_8_12.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=23"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=23"


                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_8_12.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 23
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)

//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=13&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_8_12.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }


        //*****
        time_12_4_s4.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=24"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=24"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_12_4_s4.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 24
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)



//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=14&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_12_4_s4.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }

        //*****

        time_4_8_s5.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=25"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=25"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_4_8_s5.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 25
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)



//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=15&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_4_8_s5.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }

        //*****

        time_8_12_s6.setOnClickListener {


            val url2 = GlobalVar.url_ip + "/slot_select_valid.php?slotnum=26"

            val rq2: RequestQueue = Volley.newRequestQueue(this)

            val sr2= StringRequest(Request.Method.GET,url2, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                else {

                    val url3 = GlobalVar.url_ip + "/update_availablity_temp.php?slotnum=26"

                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Slot reserved temporary go to payement", Toast.LENGTH_LONG).show()
                            time_8_12_s6.setBackgroundColor(Color.parseColor("#ff0000ff"))
                            GlobalVar.slot_temp_res = 26
                            GlobalVar.Status = 1
                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq3.add(sr3)



//                    val url = GlobalVar.url_ip + "/spot_update.php?Spot=16&name="+ userLoginInfo.name
//                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"
//
//                    val rq: RequestQueue = Volley.newRequestQueue(this)
//
//                    val sr= StringRequest(Request.Method.GET,url, { response ->
//                        if(response.equals("0"))
//                            Toast.makeText(this,"slot failed", Toast.LENGTH_LONG).show()
//                        else {
//                            Toast.makeText(this, "Slot reserved Welcome", Toast.LENGTH_LONG).show()
//                            time_8_12_s6.setBackgroundColor(Color.parseColor("#CC0000"))
//                            GlobalVar.Status = 1
//                        }
//
//                    }, { error ->
//                        Log.e("Error", error.message.toString())
//                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
//                    })
//
//                    rq.add(sr)
                }

            }, { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq2.add(sr2)


        }

        //****


        val done = findViewById<TextView>(R.id.Done_2_btn_txt)
    done.setOnClickListener {
        GlobalVar.done_reserve = 1

        if (GlobalVar.Status == 1){
            GlobalVar.enable_status_button = 1

            val i= Intent(this,Points::class.java)
            startActivity(i)
        }
        else
            Toast.makeText(this, "No Chosen Slot", Toast.LENGTH_LONG).show()
    }

    }
}