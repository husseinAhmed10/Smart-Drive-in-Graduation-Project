package part1.part1.driveapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MenuAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val lv=findViewById<ListView>(R.id.home_cat)


        val url="http://192.168.1.5/get_cat.php"
        var list=ArrayList<String>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(Request.Method.GET,url,null, { response ->
            for(x in 0 until response.length()-1)
                list.add(response.getJSONObject(x).getString("category"))

            var adp= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
            lv.adapter=adp


        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rq.add(jar)
    }

}