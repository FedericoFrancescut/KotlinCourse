package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //do a dice roll when the app starts
        rollDice1()

        //when the button is click
        rollButton.setOnClickListener {
            rollDice1()
        }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice1() {
        // Create new dice object
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable will be used based on the diceRoll
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID and update the description
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

// Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}