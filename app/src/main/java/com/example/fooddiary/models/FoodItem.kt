package com.example.fooddiary.models

class FoodItem(private var name: String , private var numCals: Int){

    fun getName() : String{
        return this.name
    }

    fun getCals() : Int{
        return this.numCals
    }

}
