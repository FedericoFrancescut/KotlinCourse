package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

/**
 * This activity allow to roll a dice and view the result on the screen.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        val resultTextView1: TextView = findViewById(R.id.textView)

        resultTextView1.text = (1..6).random().toString()
        resultTextView2.text = (1..6).random().toString()

        rollButton.setOnClickListener {
            rollDice1()
            rollDice2()
        }
    }

    private fun rollDice2() {
        //create new dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()
    }

    private fun rollDice1() {
        //create new dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}