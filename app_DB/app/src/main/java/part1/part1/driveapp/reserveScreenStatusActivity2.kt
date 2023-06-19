package part1.part1.driveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class reserveScreenStatusActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve_screen_status2)

        //reserved
        var urlp=GlobalVar.url_ip + "/reserved.php?name=" + userLoginInfo.name
        var rqp: RequestQueue = Volley.newRequestQueue(this)
        var srp= StringRequest(Request.Method.GET,urlp, { response ->

            var reserveState=findViewById<TextView>(R.id.res)

            val regex = Regex("\\d+")
            val matchResult = regex.find(response)
            val number = matchResult?.value?.toInt()

            if (number != null) {
                // Use the integer value here
                GlobalVar.reserved= number
                reserveState.text=GlobalVar.reserved.toString()
                Toast.makeText(this,"L raqm msh b null", Toast.LENGTH_LONG).show()
            }

          //  Toast.makeText(this,"L reserve asht8l", Toast.LENGTH_LONG).show()

        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })

        rqp.add(srp)



    }
}