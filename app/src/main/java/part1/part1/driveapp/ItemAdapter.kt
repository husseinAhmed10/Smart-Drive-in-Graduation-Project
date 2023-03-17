package part1.part1.driveapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.item_row.view.*


class ItemAdapter(var context:Context, var list:ArrayList<Item>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {



 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
  var v:View=LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
  return ItemHolder(v)
 }

 override fun getItemCount(): Int {
  return list.size
 }

 override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
  (holder as ItemHolder).bind(list[position].name, list[position].price)
 }

 class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  fun bind(n: String, p: Int) {
//              //val rec: RecyclerView=

   val namen=itemView.findViewById<TextView>(R.id.item_name)
   namen.text=n
   val pricep =itemView.findViewById<TextView>(R.id.item_price)
   pricep.text=p.toString()


  }

 }

}
