package part1.part1.driveapp

import android.content.Intent
import android.graphics.Color
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
        var totalPoints: Int?=0          //points got from buying
        //
        var orderAmount: Int?= GlobalVar.amount // this is the order money
        var pointsToAdd = (orderAmount.toString().toInt() * 0.1).toInt()
        totalPoints = currentPoints.toString().toInt() + pointsToAdd.toString().toInt()

        var parkingFee:Int?=GlobalVar.park
        var slotFeesTextView = findViewById<TextView>(R.id.textView_slotfee)
        if(GlobalVar.drivethru_choice == 0 && GlobalVar.driveinmenu ==0)
        {
            parkingFee=100
            slotFeesTextView.text = "Parking Space Fee: 100 L.E"
        }

        var orderTextView = findViewById<TextView>(R.id.textView_order)//credit
        orderTextView.text = "Order Fee: $orderAmount"

        var pointsTextView = findViewById<TextView>(R.id.textView2_points)
        pointsTextView.text = "Your Points: $currentPoints"

        var TotalTextView = findViewById<TextView>(R.id.textView_total)
        var total= orderAmount?.plus(parkingFee!!)
        TotalTextView.text = "Total: $total"

        var button_payment = findViewById<TextView>(R.id.button3)//button3 for payment by credit
        var buttonPoints = findViewById<TextView>(R.id.button5)
        if (currentPoints != null && currentPoints< orderAmount!!) {
           buttonPoints.isEnabled=false
        }
        else if(currentPoints!=null && currentPoints<parkingFee!! && orderAmount==0)
        {
            buttonPoints.isEnabled=false
        }


        button_payment.setOnClickListener {
            var intent = Intent(this, Credit_CardAct::class.java)
            intent.putExtra("totalPoints", totalPoints)
            startActivity(intent)
        }

        buttonPoints.setOnClickListener {

                var money = totalPoints.toString().toInt() - orderAmount.toString().toInt()  //without 100 is the slot fee

            if(GlobalVar.drivethru_choice == 0 && GlobalVar.drivein_choice == 1){
                money = money - 100       //100 is removed in drive thru choice
                GlobalVar.driveinmenu =1
                val url = GlobalVar.url_ip + "/spot_update.php?Spot="+ GlobalVar.slot_temp_res + "&name="+ userLoginInfo.name
                    //   "http://10.10.10.250/slot_select.php?slotnum=1&available=1'"

                    val rq: RequestQueue = Volley.newRequestQueue(this)

                    val sr= StringRequest(Request.Method.GET,url, { response ->
                        if(response.equals("0"))
                            Toast.makeText(this,"Reservation Failed", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this, "Space Reserved Successfully, WELCOME", Toast.LENGTH_LONG).show()
                            //time_8_12_s6.setBackgroundColor(Color.parseColor("#CC0000"))
                            GlobalVar.Status = 1
                            val url = GlobalVar.url_ip + "/AddNewPoints.php?points="+money+"&name=" + userLoginInfo.name

                            val rq: RequestQueue = Volley.newRequestQueue(this)

                            val sr= StringRequest(Request.Method.GET,url, { response ->
                                if(response.equals("0"))
                                    Toast.makeText(this,"fail in check out", Toast.LENGTH_LONG).show()
                                else {

                                    GlobalVar.points = money

                                    //  val i= Intent(this,StatusAct::class.java)
                                    //  startActivity(i)
                                    Toast.makeText(this, "Payement Complete", Toast.LENGTH_LONG).show()
                                    val url3 = GlobalVar.url_ip + "/update_availablity.php?slotnum="+ GlobalVar.slot_temp_res

                                    val rq3: RequestQueue = Volley.newRequestQueue(this)

                                    val sr3= StringRequest(Request.Method.GET,url3, { response ->
                                        if(response.equals("0"))
                                            Toast.makeText(this,"Reservation Failed", Toast.LENGTH_LONG).show()
                                        else {
                                            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
                                          //  time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))
                                          //  GlobalVar.slot_temp_res = 11
                                          //  GlobalVar.Status = 1
                                        }

                                    }, { error ->
                                        Log.e("Error", error.message.toString())
                                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                                    })

                                    rq3.add(sr3)

                                }

                            }, {
                                    error ->
                                Log.e("Error", error.message.toString())
                                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                            })

                            rq.add(sr)
                            GlobalVar.reserved = 1
                            val url1 = GlobalVar.url_ip + "/Reserved_update.php?Reserved="+GlobalVar.reserved+"&name=" + userLoginInfo.name

                            val rq1: RequestQueue = Volley.newRequestQueue(this)

                            val sr1= StringRequest(Request.Method.GET,url1, { response ->
                                if(response.equals("0"))
                                    Toast.makeText(this,"Reservation Failed", Toast.LENGTH_LONG).show()
                                else {

                                    GlobalVar.points = money

                                    //  val i= Intent(this,StatusAct::class.java)
                                    //  startActivity(i)
                                    Toast.makeText(this, "Update Reserved Status", Toast.LENGTH_LONG).show()
                                }

                            }, {
                                    error ->
                                Log.e("Error", error.message.toString())
                                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                            })

                            rq1.add(sr1)

                            if(GlobalVar.drivein_choice == 1) {  //After slot reserve, make the order
                                GlobalVar.drivein_choice = 0
                                val i = Intent(this, OrderAct::class.java)
                                startActivity(i)

                            }


                        }

                    }, { error ->
                        Log.e("Error", error.message.toString())
                        Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                    })

                    rq.add(sr)
            }

            pointsTextView.text = "Your Points: $currentPoints"
            buttonPoints.isEnabled =false
            Toast.makeText(this, "Successful Payment", Toast.LENGTH_SHORT).show()
            GlobalVar.points = money
            // Push the currentPoints to database as zero

            val url = GlobalVar.url_ip + "/AddNewPoints.php?points="+money+"&name=" + userLoginInfo.name

            val rq: RequestQueue = Volley.newRequestQueue(this)

            val sr= StringRequest(Request.Method.GET,url, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"Check-out Failed", Toast.LENGTH_LONG).show()
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
            GlobalVar.reserved = 1
            val url1 = GlobalVar.url_ip + "/Reserved_update.php?Reserved="+GlobalVar.reserved+"&name=" + userLoginInfo.name

            val rq1: RequestQueue = Volley.newRequestQueue(this)

            val sr1= StringRequest(Request.Method.GET,url1, { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"Reservation Failed", Toast.LENGTH_LONG).show()
                else {

                    GlobalVar.points = money

                    //  val i= Intent(this,StatusAct::class.java)
                    //  startActivity(i)
                    Toast.makeText(this, "Update Reserved Status", Toast.LENGTH_LONG).show()
                }

            }, {
                    error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })

            rq1.add(sr1)

            if(GlobalVar.drivein_choice == 1) {  //After slot reserve, make the order
                GlobalVar.drivein_choice = 0
                val i = Intent(this, OrderAct::class.java)
                startActivity(i)

            }
            else{
                val i= Intent(this,StatusAct::class.java)
                startActivity(i)
            }



        }
        var buttonPromoCode=findViewById<TextView>(R.id.button_promocode)
        buttonPromoCode.setOnClickListener {
            val intent = Intent(this, Promocode::class.java)
            startActivity(intent)
        }


        }

    }
