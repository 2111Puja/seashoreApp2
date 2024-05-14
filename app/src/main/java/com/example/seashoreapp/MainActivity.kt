package com.example.seashoreapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Declaring variables
    private lateinit var calculateButton: Button
    private lateinit var minutesInput: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing variables
        calculateButton = findViewById(R.id.calculateBtn)
        minutesInput = findViewById(R.id.minutesInput)
        resultTextView = findViewById(R.id.resultTextView)

        // Setting OnClickListener for the calculateButton
        calculateButton.setOnClickListener {
            val inputText = minutesInput.text.toString()
            val minutes = if (inputText.isNotEmpty()) {
                inputText.toIntOrNull() ?: 0
            } else {
                0
            }

            val hours = calculateTotalHours(minutes)
            val additionalMinutes = calculateRemainingMinutes(minutes)
            val totalPrice = calculateTotalPrice(minutes)

            resultTextView.text = "Hours rented: $hours\nMinutes rented: $additionalMinutes\nTotal price: R$totalPrice"
        }
    }

    fun calculateTotalPrice(minutes: Int): Int {
        val hours = minutes / 60
        val additionalMinutes = minutes % 60
        val totalPrice = hours * 400 + additionalMinutes * 1
        return totalPrice
    }

    fun calculateTotalHours(minutes: Int): Int {
        val hours = minutes / 60
        return hours
    }

    fun calculateRemainingMinutes(minutes: Int): Int {
        val additionalMinutes = minutes % 60
        return additionalMinutes
    }
}

