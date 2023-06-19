package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RegAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val txtbtnclick = findViewById<TextView>(R.id.reg_signup_btn_txt)


        txtbtnclick.setOnClickListener {
            GlobalVar.promo=3
            var initialpoints=0


            val name = findViewById<EditText>(R.id.reg_Name).text.toString()
            val email = findViewById<EditText>(R.id.reg_email).text.toString()
            val mobPhone = findViewById<EditText>(R.id.reg_phone).text.toString()
            val pass = findViewById<EditText>(R.id.reg_Password).text.toString()
            val confPass = findViewById<EditText>(R.id.reg_confirm_Password).text.toString()

            if(confPass.equals(pass)) {

                val url =
                    GlobalVar.url_ip + "/add_user.php?name=" + name + "&email=" + email + "&phone=" + mobPhone + "&password=" + pass + "&Spot=" + GlobalVar.spot+ "&points=" +initialpoints+"&Reserved=" + GlobalVar.reserved+"&arrived=" +  GlobalVar.arrived +"&promocode=" + GlobalVar.promo + "&credit=" + GlobalVar.creditcard

                val rq:RequestQueue=Volley.newRequestQueue(this)

                val sr=StringRequest(Request.Method.GET,url, { response ->
                    if(response.equals("0"))
                        Toast.makeText(this,"This name is already taken, try another one",Toast.LENGTH_LONG).show()
                    else {
                        userLoginInfo.name = name
                        val i= Intent(this,HomeAct::class.java)
                        startActivity(i)
                     //   Toast.makeText(this, "User Created Welcome", Toast.LENGTH_LONG).show()
                    }

                }, { error ->
                    Log.e("Error", error.message.toString())
//                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rq.add(sr)
            }
            else
                Toast.makeText(this,"Passwords don't match",Toast.LENGTH_LONG).show()
        }


    }
}