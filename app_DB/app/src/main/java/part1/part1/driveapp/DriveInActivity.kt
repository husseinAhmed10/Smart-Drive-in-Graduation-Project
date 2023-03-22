package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DriveInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drive_in)

        val txt_btn_click = findViewById<TextView>(R.id.check_slot_btn_txt)
        txt_btn_click.setOnClickListener{
            val i= Intent(this,ReserveAct::class.java)
            startActivity(i)
        }


    }
}