package com.example.fooddiary.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.fooddiary.models.FoodItem

class FoodViewModel(application: Application) : AndroidViewModel(application){
    private var _foodList: MutableLiveData<ArrayList<FoodItem>> = MutableLiveData()

    fun addItem(food : FoodItem){
    }

}
