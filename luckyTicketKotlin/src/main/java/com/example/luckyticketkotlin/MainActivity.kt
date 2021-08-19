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
    companion object {
        const val NUMBER_OF_DIGITS = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun onClick(view: View) {
        val input = findViewById<EditText>(R.id.etTicketNumber).text.toString()
        val bulb = findViewById<ImageView>(R.id.imgBulb)
        val bulbGreen = getDrawable(R.drawable.ic_bulbgreen)
        val bulbRed = getDrawable(R.drawable.ic_bulbred)

        if (input.length == NUMBER_OF_DIGITS) {
            try {
                val result = input.toCharArray().map { it.toString().toInt() }

                if (result[0] + result[1] + result[2] == result[3] + result[4] + result[5]) {
                    bulb.setImageDrawable(bulbGreen)
                } else {
                    bulb.setImageDrawable(bulbRed)
                }
            } catch (ex: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    "You need to enter only digits",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "You must enter 6 digits",
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}