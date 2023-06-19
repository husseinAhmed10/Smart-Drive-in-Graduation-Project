package part1.part1.driveapp

import android.app.Application

class GlobalVar : Application() {

    companion object {
        var url_ip = "http://192.168.128.1"
        var Status: Int?= 0        //if he reserved slot, it is true (i.e. = 1)
        var enable_status_button: Int?=0    //to control status button

        var reserved: Int?= 0   //if he reserved already slot, when login open status menu not the home

        var point_btn: Int?=0   //to show the points in button menu (1 show 0 no)
        var drivethru_choice: Int?=0
        var drivein_choice: Int?=0

        var done_reserve: Int?=0    //slot is done reserve
        var done_ordering: Int?=0    //order is done reserved

        var slot_temp_res: Int?=0    //slot num is stored here until payement is done reserved
       // var slot_fee_minimum: Int?=100  //minimum slot fee (a2al mn keda msh hy3rf y7gz)

        var driveinmenu: Int?=0     //show parking fee in slot payement only



        var points:Int?=0
        var order_points: Int?= 700  //700 is test
        var amount=0
        var park=0
        var promo:Int?=0
        var creditcard:Int?=0
        var spot=0
        var arrived=0
        var Total_card_No=""
    }
 //   var name: String? = null

}