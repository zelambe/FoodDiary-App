package com.example.fooddiary.models

class CaloriesRemaining(private var initalCals: Int){

    fun getTotalCals(): Int {
        return this.initalCals;
    }

    fun decreaseCals(input: Int): Int{
        this.initalCals -= input;
        return this.initalCals;
    }

}