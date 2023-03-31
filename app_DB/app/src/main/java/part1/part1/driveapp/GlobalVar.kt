package part1.part1.driveapp

import android.app.Application

class GlobalVar : Application() {

    companion object {
        var Status: Int? = 0        //if he reserved slot, it is true (i.e. = 1)
    }
 //   var name: String? = null

}