package com.example.fooddiary

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.fooddiary.models.FoodItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var listItems: ArrayList<FoodItem> = ArrayList<FoodItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.hasExtra("Starting Calories")){
            CaloriesRemainingTextView.text = intent.getIntExtra("Starting Calories", 0).toString()
        }

        TotalCaloriesTextView.text = "0" //start out at 0


        val adapter : FoodListAdapter = FoodListAdapter(this ,R.layout.row_layout ,listItems)
        foodList.adapter = adapter


        addFoodItemButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val intent = Intent(this@MainActivity, AddItemActivity::class.java)

                startActivityForResult(intent, 1)
            }
        })

    }

    override fun onStart() {
        super.onStart()
    }

    public fun addFood(food: FoodItem){
        Log.d("debug","add food: " + food.getName())
        listItems.add(food);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if (requestCode ==1){
                if(resultCode == Activity.RESULT_OK){
                        val newFoodName: String = data!!.getStringExtra("FOOD")
                        val newFoodCals: Int = data!!.getIntExtra("CALS",0)

                        Log.d("debug", "Main activity: New food Name: " + newFoodName + ", cals: " + newFoodCals )
                        val newFood : FoodItem = FoodItem(newFoodName,newFoodCals)

                        addFood(newFood)
                        val adapter : FoodListAdapter = FoodListAdapter(this, R.layout.row_layout, listItems)
                        foodList.adapter = adapter

                        if(!listItems.isEmpty()){
                            for (i in listItems.indices){
                                Log.d("debug","li: "+ listItems[i].getName())
                            }
                        }

                        var RemainingCals :Int = CaloriesRemainingTextView.text.toString().toInt()
                        RemainingCals -= newFoodCals

                        var EatenCals: Int = TotalCaloriesTextView.text.toString().toInt()
                        EatenCals += newFoodCals

                        CaloriesRemainingTextView.text = RemainingCals.toString()
                        TotalCaloriesTextView.text = EatenCals.toString()

                        if(RemainingCals < 0){
                            CaloriesRemainingTextView.setTextColor(Color.RED)
                        }else{
                            //how to get it back?
                        }


                }
            }
    }
}
