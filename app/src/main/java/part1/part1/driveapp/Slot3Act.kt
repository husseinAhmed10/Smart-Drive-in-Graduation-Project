package part1.part1.driveapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Slot3Act : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slot3)


        val time_12_4 = findViewById<TextView>(R.id.slot_3_1_btn_txt)
        val time_4_8 = findViewById<TextView>(R.id.slot_3_2_btn_txt)
        val time_8_12 = findViewById<TextView>(R.id.slot_3_3_btn_txt)


        time_12_4.setOnClickListener {

            time_12_4.setBackgroundColor(Color.parseColor("#CC0000"))


        }
        time_4_8.setOnClickListener {

            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))


        }
        time_8_12.setOnClickListener {

            time_4_8.setBackgroundColor(Color.parseColor("#CC0000"))

        }

        val done = findViewById<TextView>(R.id.Done_3_btn_txt)

        done.setOnClickListener{

            //    if(1) {
            //     slot1_btn_click.setBackgroundColor(Color.parseColor("#CC0000"))
            //     Toast.makeText(this, "Slot 1 is reserved", Toast.LENGTH_LONG).show()
            // }
            //    else
            //       Toast.makeText(this, "Failed::Slot 1 is already reserved", Toast.LENGTH_LONG).show()


            val i= Intent(this,CheckOutAct::class.java)
            startActivity(i)
        }

    }
}