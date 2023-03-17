package part1.part1.driveapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class ReserveAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve)


        val slot1_btn_click = findViewById<TextView>(R.id.slot_1_btn_txt)
        val slot2_btn_click = findViewById<TextView>(R.id.slot_2_btn_txt)
        val slot3_btn_click = findViewById<TextView>(R.id.slot_3_btn_txt)
        val slot4_btn_click = findViewById<TextView>(R.id.slot_4_btn_txt)

       // val slot1_db = "ur1"

        slot1_btn_click.setOnClickListener{

        //    if(1) {
           //     slot1_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
           //     Toast.makeText(this, "Slot 1 is reserved", Toast.LENGTH_LONG).show()
           // }
        //    else
         //       Toast.makeText(this, "Failed::Slot 1 is already reserved", Toast.LENGTH_LONG).show()


              val i= Intent(this,Slot1Act::class.java)
              startActivity(i)
        }

        slot2_btn_click.setOnClickListener{

            //    if(1) {
          //  slot2_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
        //    Toast.makeText(this, "Slot 2 is reserved", Toast.LENGTH_LONG).show()

            // }
            //    else
        //    Toast.makeText(this, "Failed::Slot 2 is already reserved", Toast.LENGTH_LONG).show()


            val i= Intent(this,Slot2Act::class.java)
            startActivity(i)
        }

      //  Thread.sleep(200000L)
      //  slot3_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))

        slot3_btn_click.setOnClickListener{

            //    if(1) {
           // slot3_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
           // Toast.makeText(this, "Slot 3 is reserved", Toast.LENGTH_LONG).show()
            // }
            //    else
          //  Toast.makeText(this, "Failed::Slot 3 is already reserved", Toast.LENGTH_LONG).show()


            val i= Intent(this,Slot3Act::class.java)
            startActivity(i)
        }
        slot4_btn_click.setOnClickListener{

            //    if(1) {
           // slot4_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
           // Toast.makeText(this, "Slot 4 is reserved", Toast.LENGTH_LONG).show()
            // }
            //    else
           // Toast.makeText(this, "Failed::Slot 4 is already reserved", Toast.LENGTH_LONG).show()

            val i= Intent(this,Slot4Act::class.java)
            startActivity(i)
        }

    }



}