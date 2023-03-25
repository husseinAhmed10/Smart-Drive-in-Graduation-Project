package part1.part1.driveapp

import android.app.Application

class GlobalVar : Application() {

    var Status = 0
    fun setGlobalValue(newValue: Int) {
        Status = newValue
    }

}