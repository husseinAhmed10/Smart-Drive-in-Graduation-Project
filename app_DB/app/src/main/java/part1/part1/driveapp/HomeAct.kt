package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class HomeAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cinemabtnclick = findViewById<TextView>(R.id.cinema_btn_txt)
        val drive_in_btnclick = findViewById<TextView>(R.id.drive_btn_txt)
        val drive_thru_btnclick = findViewById<TextView>(R.id.drive_thru_txt)


        cinemabtnclick.setOnClickListener {

            Toast.makeText(this,"This option is closed at the moment", Toast.LENGTH_LONG).show()
        }

        drive_in_btnclick.setOnClickListener {

            val i= Intent(this,DriveInActivity::class.java)
            startActivity(i)
        }

        drive_thru_btnclick.setOnClickListener {

            val i= Intent(this,OrderAct::class.java)
            startActivity(i)
          //  Toast.makeText(this,"This option waits for poka", Toast.LENGTH_LONG).show()
        }









    }
}