package part1.part1.driveapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_btn_click = findViewById<TextView>(R.id.signup_btn_txt)
        txt_btn_click.setOnClickListener{
            val i= Intent(this,RegAct::class.java)
            startActivity(i)
        }

        val txt_btn_click_login = findViewById<TextView>(R.id.login_btn_txt)
        txt_btn_click_login.setOnClickListener{

            val name = findViewById<EditText>(R.id.login_Name).text.toString()
            val pass = findViewById<EditText>(R.id.login_Password).text.toString()

            var url = GlobalVar.url_ip + "/login.php?name=" + name + "&password=" + pass

            var rq: RequestQueue = Volley.newRequestQueue(this)

            var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->
                if(response.equals("0"))
                    Toast.makeText(this,"Login fail: incorrect password or name", Toast.LENGTH_LONG).show()
                else {
                    userLoginInfo.name = name

                    //reserved
                    var urlp=GlobalVar.url_ip + "/reserved.php?name=" + userLoginInfo.name
                    var rqp: RequestQueue = Volley.newRequestQueue(this)
                    var srp= StringRequest(Request.Method.GET,urlp, { response ->

                        val regex = Regex("\\d+")
                        val matchResult = regex.find(response)
                        val number = matchResult?.value?.toInt()

                        if (number != null) {
                            // Use the integer value here
                            GlobalVar.reserved= number

                            //   Toast.makeText(this,"L raqm msh b null", Toast.LENGTH_LONG).show()
                        }

                        if (GlobalVar.reserved == 0)
                        {
                            val i= Intent(this,HomeAct::class.java)
                            startActivity(i)
                            //      Toast.makeText(this,"Home", Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            val i= Intent(this,Points::class.java)
                            startActivity(i)
                            //      Toast.makeText(this,"Status", Toast.LENGTH_LONG).show()
                        }

                        //  Toast.makeText(this,"L reserve asht8l", Toast.LENGTH_LONG).show()

                    }, { error ->
                        Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                    })

                    rqp.add(srp)


                }

            }) { error ->
                Log.e("Error", error.message.toString())
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }

            rq.add(sr)

//            val i= Intent(this,reserveScreenStatusActivity2::class.java)
//            startActivity(i)

        }

    }
}







