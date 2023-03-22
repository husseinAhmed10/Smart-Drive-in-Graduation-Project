package part1.part1.driveapp


import android.app.DownloadManager.Request
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
//import kotlinx.android.synthetic.main.activity_item.*


class itemAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        var cat: String? =intent.getStringExtra("cat")
        var url="http://10.10.10.250/get_items.php?category="+cat
        var list=ArrayList<Item>()

        var rq:RequestQueue=Volley.newRequestQueue(this)
        var jar=JsonArrayRequest(com.android.volley.Request.Method.GET,url, null, { response ->

            for(x in 0..response.length()-1)
                list.add(Item(response.getJSONObject(x).getInt("id"),response.getJSONObject(x).getString("name"),
                    response.getJSONObject(x).getInt("price")))

            var adp=ItemAdapter(this,list)
            val itemrv=findViewById<RecyclerView>(R.id.item_rv)

            itemrv.layoutManager=LinearLayoutManager(this)
            itemrv.adapter=adp
        }, { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

        })
        rq.add(jar)

    }
}