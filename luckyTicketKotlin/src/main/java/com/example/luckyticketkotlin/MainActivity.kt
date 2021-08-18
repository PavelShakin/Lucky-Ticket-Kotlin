package com.example.luckyticketkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun onClick(view: View) {
        val input = findViewById<EditText>(R.id.editText).text.toString()
        val bulb = findViewById<ImageView>(R.id.bulb)
        val bulbGreen = getDrawable(R.drawable.bulbgreen)
        val bulbRed = getDrawable(R.drawable.bulbred)

        if (input.length == 6) {
            try {
                val number = input.toInt()
                if (number == 0) {
                    bulb.setImageDrawable(bulbGreen)
                } else if (number / 100000 == number % 10) {
                    if (number / 10000 % 10 == number % 100 / 10) {
                        if (number / 1000 % 10 == number % 1000 / 100) {
                            bulb.setImageDrawable(bulbGreen)
                        }
                    }
                } else {
                    bulb.setImageDrawable(bulbRed)
                }
            } catch (ex: NumberFormatException) {
                val toast = Toast.makeText(
                    applicationContext,
                    "You need to enter only numbers",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }
        } else {
            val toast = Toast.makeText(
                applicationContext,
                "You mush enter 6 numbers",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}