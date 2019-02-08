package com.example.fooddiary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.fooddiary.R.*
import com.example.fooddiary.models.FoodItem

import kotlinx.android.synthetic.main.activity_add_item.*
import kotlinx.android.synthetic.main.activity_main.*

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_add_item)


            button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                val newFoodName = enterFoodNameTextView.text.toString()
                val newFoodCals = enterNumCaloriesTextView.text.toString().toInt()
                    val intent = Intent(this@AddItemActivity, MainActivity::class.java)
                    intent.putExtra("FOOD", newFoodName)
                    intent.putExtra("CALS",newFoodCals)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
            }
        })

    }



}
