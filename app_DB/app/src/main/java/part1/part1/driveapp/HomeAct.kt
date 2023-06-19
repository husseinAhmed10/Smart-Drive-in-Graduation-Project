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

           // val i= Intent(this, CheckOutAct::class.java)
           // startActivity(i)
            Toast.makeText(this,"This option is closed at the moment", Toast.LENGTH_LONG).show()
        }

        drive_in_btnclick.setOnClickListener {

            GlobalVar.drivein_choice = 1
            val i= Intent(this,DriveInActivity::class.java)
            startActivity(i)
        }

        drive_thru_btnclick.setOnClickListener {

            GlobalVar.drivethru_choice = 1
            val i= Intent(this,OrderAct::class.java)
            startActivity(i)
          //  Toast.makeText(this,"This option waits for poka", Toast.LENGTH_LONG).show()
        }
        var logoutt=findViewById<TextView>(R.id.logout3)
        logoutt.setOnClickListener{

            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}