package part1.part1.driveapp

import android.app.Application

class GlobalVar : Application() {

    companion object {
        var url_ip = "http://192.168.1.5"
        var Status: Int?= 0        //if he reserved slot, it is true (i.e. = 1)
        var enable_status_button: Int?=0    //to control status button

        var points:Int?=0
        var order_points: Int?= 700  //700 is test
        var amount=0

    }
 //   var name: String? = null

}