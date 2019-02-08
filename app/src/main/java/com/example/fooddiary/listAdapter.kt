package com.example.fooddiary

import android.content.Context
import android.database.DataSetObserver
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fooddiary.R.*
import com.example.fooddiary.models.FoodItem
import kotlinx.android.synthetic.main.row_layout.view.*


//https://android.jlelse.eu/creating-custom-array-adapters-in-android-a-better-way-dc492c89512
class FoodListAdapter(context: Context, @LayoutRes private val layoutResource: Int, private val foods: ArrayList<FoodItem>):
    ArrayAdapter<FoodItem>(context, layoutResource, foods){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val name :String = foods[position].getName()
        val cals: Int = foods[position].getCals()

        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(layoutResource, parent,false)

        var foodNameText:TextView =view.FoodItemName
        var foodCalsText:TextView = view.FoodItemCalories

        foodNameText.text = name
        foodCalsText.text = cals.toString()

        return view

    }

}
