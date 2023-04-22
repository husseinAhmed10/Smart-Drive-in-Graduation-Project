package part1.part1.driveapp

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

private fun getValueFromQuery(): Int {
    val url = URL(GlobalVar.url_ip + "/Get_points.php? name=" + userLoginInfo.name)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    try {
        val inputStream = connection.inputStream
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            response.append(line)
        }
        bufferedReader.close()
        return response.toString().toInt()
    } catch (e: Exception) {
        e.printStackTrace()
        return -1
    } finally {
        connection.disconnect()
        }

}

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

                        //GlobalVar.points =

                    //    val i= Intent(this,HomeAct::class.java)
                    //    startActivity(i)
                        //   Toast.makeText(this, "User Created Welcome", Toast.LENGTH_LONG).show()
                    }

                }, {
                        error ->
                    Log.e("Error", error.message.toString())
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

            rq.add(sr)

            ///////
            //val lv=findViewById<TextView>(R.id.home_cat)


            val url_points= GlobalVar.url_ip + "/Get_points.php?name=" + name
            var list=ArrayList<String>()

            var rq_point: RequestQueue = Volley.newRequestQueue(this)
//            var jar= JsonArrayRequest(Request.Method.GET,url_points,null, { response ->
//                list.add(response.getJSONObject(0).getString("points"))
//
//                var adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
//                GlobalVar.points  = adp
//
//            }
            /////


                // GlobalVar.points = getValueFromQuery()
            //GlobalVar.points = 1000
//            Log.d("Points", "Points for $name: $GlobalVar.points")

            val i= Intent(this,HomeAct::class.java)
            startActivity(i)

        }




    }
}