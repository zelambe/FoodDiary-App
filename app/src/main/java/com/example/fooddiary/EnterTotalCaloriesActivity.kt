package com.example.fooddiary

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.fooddiary.fragments.InputCaloriesFragment
import com.example.fooddiary.models.TotalCalories

import kotlinx.android.synthetic.main.activity_enter_total_calories.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_input_calories.*

//This activity holds the InputCaloriesFragment

class EnterTotalCaloriesActivity : AppCompatActivity(), InputCaloriesFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_total_calories)

        TotalCaloriesButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                if(inputTotalCaloriesText.text.toString() ==""){
                    var toast:Toast =Toast.makeText(this@EnterTotalCaloriesActivity,"Input A Number", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.TOP, 0,0)
                    toast.show()

                }else {
                    val intent = Intent(this@EnterTotalCaloriesActivity, MainActivity::class.java)
                    intent.putExtra("Starting Calories", inputTotalCaloriesText.text.toString().toInt())
                    startActivity(intent)
                }
            }
        })

        }

    override fun onFragmentInteraction(uri: Uri) {
        val totalCalories: Int = inputTotalCaloriesText.text.toString().toInt()
        CaloriesRemainingTextView.text = totalCalories.toString();
    }


}
