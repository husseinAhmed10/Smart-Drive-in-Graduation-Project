package part1.part1.driveapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CheckOutAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        //
        var currentPoints: Int = 700    //my points
        var totalPoints=0               //points got from buying
        //
        val orderAmount = 600 // this is the order money
        val pointsToAdd = (orderAmount * 0.1).toInt()
        totalPoints = currentPoints + pointsToAdd

        val orderTextView = findViewById<TextView>(R.id.textView_order)//credit
        orderTextView.text = "Your Order: $orderAmount"

        val pointsTextView = findViewById<TextView>(R.id.textView2_points)
        pointsTextView.text = "Your Point L.E: $currentPoints"

        val button_payment = findViewById<Button>(R.id.button3)//button3 for payment by credit
        button_payment.isEnabled = totalPoints < orderAmount

        val buttonPoints = findViewById<Button>(R.id.button5)
        buttonPoints.isEnabled = totalPoints >= orderAmount


        button_payment.setOnClickListener {
            var intent = Intent(this, Credit_CardAct::class.java)
            intent.putExtra("totalPoints", totalPoints)
            startActivity(intent)
        }

        buttonPoints.setOnClickListener {
            currentPoints = totalPoints-orderAmount
            pointsTextView.text = "Your Point L.E: $currentPoints"
            buttonPoints.isEnabled =false
            Toast.makeText(this, "Successfully Payment", Toast.LENGTH_SHORT).show()

            // Push the currentPoints to database as zero

            //

            var intent = Intent(this, DriveInActivity::class.java)
            startActivity(intent)



        }

    }
}