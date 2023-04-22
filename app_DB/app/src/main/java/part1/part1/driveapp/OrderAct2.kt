package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class OrderAct2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_act2)

        var url = GlobalVar.url_ip + "/get_temp.php?phone=" + userLoginInfo.phone

        var list = ArrayList<String>()
        var rq: RequestQueue = Volley.newRequestQueue(this)

        var jar = JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, { response ->

            for (x in 0..response.length() - 1)
                list.add(
                   "Name : " + response.getJSONObject(x).getString("name") + "\n" +
                           "Price : " + response.getJSONObject(x)
                        .getString("price")
                            + "\n" +
                           "Quantity : " +response.getJSONObject(x).getString("qty")
                )

            var adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
            var orderlv = findViewById<ListView>(R.id.order_lv)
            orderlv.adapter = adp

        }, Response.ErrorListener { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
        })

    rq.add(jar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if(item?.itemId==R.id.item_menu)
        {
            var i= Intent(this,OrderAct::class.java)
            startActivity(i)
        }
        if (item?.itemId==R.id.item_cancel)
        {
            var url=GlobalVar.url_ip + "/cancel_order.php?phone=" + userLoginInfo.phone

            var rq:RequestQueue=Volley.newRequestQueue(this)
            var sr=StringRequest(Request.Method.GET,url, { response ->
                var i=Intent(this,HomeAct::class.java)
                startActivity(i)

            }, { error ->
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })
            rq.add(sr)
        }
        if(item?.itemId==R.id.item_confirm)
        {
            var url=GlobalVar.url_ip + "/confirm_order.php?phone=" + userLoginInfo.phone
            var rq:RequestQueue=Volley.newRequestQueue(this)
            var sr=StringRequest(Request.Method.GET,url, { response ->
                var i=Intent(this,TotalAct::class.java)
                i.putExtra("bno",response)
                startActivity(i)

            }, { error ->
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
            })
            rq.add(sr)

        }
       return super.onOptionsItemSelected(item)
    }


}