package part1.part1.driveapp

import java.sql.Blob

class Item {

    var id:Int
    var name:String
    var price:Int
    var photo:String

    constructor(id:Int, name:String, price:Int, photo: String)
    {
        this.id=id
        this.name=name
        this.price=price
        this.photo=photo

    }

}