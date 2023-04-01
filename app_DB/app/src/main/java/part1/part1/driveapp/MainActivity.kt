package part1.part1.driveapp

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_btn_click = findViewById<TextView>(R.id.signup_btn_txt)
        txt_btn_click.setOnClickListener{
            val i= Intent(this,RegAct::class.java)
            startActivity(i)
        }

        val name = findViewById<EditText>(R.id.login_Name).text.toString()
        val pass = findViewById<EditText>(R.id.login_Password).text.toString()

        val txt_btn_click_login = findViewById<TextView>(R.id.login_btn_txt)
        txt_btn_click_login.setOnClickListener{

                val url = GlobalVar.url_ip + "/login.php?name=" + name + "&password=" + pass

                val rq: RequestQueue = Volley.newRequestQueue(this)

                val sr= StringRequest(Request.Method.GET,url, { response ->
                    if(response.equals("0"))
                        Toast.makeText(this,"Login fail: incorrect password or name", Toast.LENGTH_LONG).show()
                    else {
                        userLoginInfo.name = name
                        val i= Intent(this,HomeAct::class.java)
                        startActivity(i)
                        //   Toast.makeText(this, "User Created Welcome", Toast.LENGTH_LONG).show()
                    }

                }, {
                        error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

            rq.add(sr)

        }




    }
}