package com.example.fooddiary.models

class TotalCalories(private var initalCals: Int){

    fun getTotalCals(): Int {
        return this.initalCals;
    }

    fun increaseCals(input: Int): Int{
        this.initalCals += input;
        return this.initalCals;
    }

}
