package part1.part1.driveapp

import android.app.Application

class GlobalVar : Application() {

    companion object {
        var url_ip = "http://192.168.1.24"
        var Status: Int? = 0        //if he reserved slot, it is true (i.e. = 1)
    }
 //   var name: String? = null

}