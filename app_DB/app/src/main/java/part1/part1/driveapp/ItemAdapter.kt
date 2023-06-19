package part1.part1.driveapp


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.sql.Blob

//import kotlinx.android.synthetic.main.item_row.view.*


@Suppress("DEPRECATION")
class ItemAdapter(var context:Context, var list:ArrayList<Item>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
  var v:View=LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
  return ItemHolder(v)
 }

 override fun getItemCount(): Int {
  return list.size
 }

 override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
  (holder as ItemHolder).bind(list[position].name, list[position].price ,list[position].id, list[position].photo)
 }

 class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  fun bind(n: String, p: Int, item_id:Int, u:String) {
//              //val rec: RecyclerView=

   val namen=itemView.findViewById<TextView>(R.id.item_name)
   namen.text=n
   val pricep =itemView.findViewById<TextView>(R.id.item_price)
   pricep.text=p.toString()
   val photoph=itemView.findViewById<ImageView>(R.id.item_photo)
   var web:String="http://192.168.1.5/applweb/items/"+u
   web=web.replace(" ","%20")
   with(Picasso.get()) {
    load("http://192.168.1.5/applweb/items/" + u).into(photoph)
   }

   val butadd=itemView.findViewById<ImageView>(R.id.item_add_photo)
   butadd.setOnClickListener {
     userLoginInfo.itemId=item_id
     var obj=QtyFragment() 
     var manager=(itemView.context as Activity).fragmentManager
     obj.show(manager, "Qty")
   }


  }

 }

}
