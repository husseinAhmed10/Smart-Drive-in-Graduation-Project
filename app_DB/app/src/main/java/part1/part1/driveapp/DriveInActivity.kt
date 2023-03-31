package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DriveInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drive_in)

        val txt_btn_click = findViewById<TextView>(R.id.check_slot_btn_txt)
        txt_btn_click.setOnClickListener {
            if (GlobalVar.Status == 0) {
                val i = Intent(this, ReserveAct::class.java)
                startActivity(i)
            }else {
                Toast.makeText(this, "You already reserved a spot", Toast.LENGTH_LONG).show()
                GlobalVar.Status = 1
            }

        }
        val check_btn_click = findViewById<TextView>(R.id.status_txt)
        check_btn_click.setOnClickListener {

            if (GlobalVar.Status == 1) {
                val i = Intent(this, StatusAct::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "You didn't reserve a spot", Toast.LENGTH_LONG).show()
                GlobalVar.Status = 1
            }

        }
    }
}