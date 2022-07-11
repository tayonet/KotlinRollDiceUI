package com.example.kotlinrolldiceui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    // create references to views
    lateinit var current_score : TextView
    lateinit var die1 : ImageView
    lateinit var die2 : ImageView
    lateinit var btn_roll : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instantiate the references
        die1 = findViewById(R.id.die1)
        die2 = findViewById(R.id.die2)
        btn_roll = findViewById(R.id.btn_roll)
        current_score = findViewById(R.id.score)

        // create variables to hold scores and repeat variable
        var score = 0
        var repeat =0

        // write code for the button click event

        btn_roll.setOnClickListener{

            if(repeat <= 4 && score >= 30 ) {
               var  alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Success")
                alertDialog.setMessage("You have won!!!")
                alertDialog.setPositiveButton("OK") {text,listener -> {

                }}
                alertDialog.setNegativeButton("CANCEL"){text,listener -> {

                }}
                alertDialog.create()
                alertDialog.show()
            }else if (repeat >= 4 && score < 30 ){
                var  alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("You Failed")
                alertDialog.setMessage("You have lost!!!")
                alertDialog.setPositiveButton("OK") {text,listener -> {

                }}
                alertDialog.setNegativeButton("CANCEL"){text,listener -> {

                }}
                alertDialog.create()
                alertDialog.show()
            } else {
                // get the random values for the dice
                var  rand1 = Random().nextInt(6)+ 1
                score += rand1
                var rand2 = Random().nextInt(6) + 1
                score += rand2
                // call the selectDieImage twice with parameters rand1 and rand2
                selectDieImage(rand1,die1)
                selectDieImage(rand2,die2)

                // set the value of score to current score variable
                current_score.text = Integer.toString(score)
                repeat +=1
            }


        }
    }

    fun selectDieImage( rand_value : Int, die : ImageView) {
        val image = when (rand_value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        // set the image resource for the die1 object
        die.setImageResource(image)
    }
}