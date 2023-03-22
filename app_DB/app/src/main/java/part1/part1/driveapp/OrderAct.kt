package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class OrderAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val lv=findViewById<ListView>(R.id.home_cat)


        val url="http://10.10.10.250/add_emp.php"
        var list=ArrayList<String>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(Request.Method.GET,url,null, { response ->
            for(x in 0 .. response.length()-1)
                list.add(response.getJSONObject(x).getString("category"))

            var adp= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
            lv.adapter=adp


        }, { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rq.add(jar)

        lv.setOnItemClickListener { parent, view, position, id ->
            var cat:String=list[position]
            var obj= Intent(this,itemAct::class.java)
            obj.putExtra("cat",cat)
            startActivity(obj)
        }

    }

}
