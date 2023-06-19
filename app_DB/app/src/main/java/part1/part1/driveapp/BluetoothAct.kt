package part1.part1.driveapp

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BluetoothAct : AppCompatActivity() {

    private val REQUEST_CODE_ENABLE_BT:Int = 1;
    private val REQUEST_CODE_DISCOVERABLE_BT:Int = 2;


    //bluetooth adapter
    lateinit var bAdapter:BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        //init bluetooth adapter
        bAdapter = BluetoothAdapter.getDefaultAdapter()
        //getDefaultAdapter() is not supported return null

        //check if bluetooth is available or not
        if(bAdapter==null)
        {
            findViewById<TextView>(R.id.bluetoothStatus).text ="Bluetooth is not available"
        }
        else
        {
            findViewById<TextView>(R.id.bluetoothStatus).text ="Bluetooth is available"
        }

        //turn on bluetooth
        findViewById<TextView>(R.id.bluetoothTurnON).setOnClickListener{

            if(bAdapter.isEnabled){
                Toast.makeText(this, "Already on",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
              //  startActivityForResult(intent,REQUEST_CODE_ENABLE_BT);
                //startActivity(intent)
            }

        }

        //turn off bluetooth
        findViewById<TextView>(R.id.bluetoothTurnOFF).setOnClickListener{

            if(!bAdapter.isEnabled){
                Toast.makeText(this, "Already off",Toast.LENGTH_LONG).show()
            }
            else
            {
            //    bAdapter.disable()
                Toast.makeText(this, "Bluetooth turned off",Toast.LENGTH_LONG).show()
            }

        }

        //Discoverable bluetooth
        findViewById<TextView>(R.id.bluetoothDiscoverable).setOnClickListener{

     //       if(!bAdapter.isDiscovering)
     //       {
     //           Toast.makeText(this, "Making your device discoverable",Toast.LENGTH_LONG).show()
     //           val intent = Intent(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
    //            startActivityForResult(intent,REQUEST_CODE_DISCOVERABLE_BT);
    //        }


        }

        //paired but
        findViewById<Button>(R.id.PairedBtn).setOnClickListener {

            if (bAdapter.isEnabled)
            {
                findViewById<TextView>(R.id.pairedDevices).text = "paired"
                //get list of devices
           //     val devices = bAdapter.bondedDevices
         //       for(device in devices)
         //       {
          //          val deviceName = device.name
          //          val deviceAddress = device
         //           findViewById<TextView>(R.id.pairedDevices). append("\nDevice: $deviceName , $device")

         //       }
            }
            else
            {
                Toast.makeText(this, "Turn Bluetooth on",Toast.LENGTH_LONG).show()
            }
        }

        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when (requestCode) {
            REQUEST_CODE_ENABLE_BT ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(this, "Bluetooth is on",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, "couldn't on bluetooth",Toast.LENGTH_LONG).show()
                }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}