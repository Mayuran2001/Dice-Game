package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ComputerPopupWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_popup_window)

        //Computer popup window implementation
        // Display the computer win message
        val message = findViewById<TextView>(R.id.textView15)

        //display the total score of computer
        val messageScore = findViewById<TextView>(R.id.textView16)

        //Back button to the main page
        val back = findViewById<Button>(R.id.button4)

        //Retrieving data from another activity
        val computer = intent.getStringExtra("computer")
        val computerScore = intent.getIntExtra("computer score",0)

        val totalComputerWins = intent.getIntExtra("comWins",0)
        val totalHumanWins = intent.getIntExtra("humWins",0)

        message.text = computer.toString()
        messageScore.text = computerScore.toString()

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("totalComputerWins",totalComputerWins)
            intent.putExtra("totalHumanWins",totalHumanWins)
            startActivity(intent)
        }
    }
}