package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HumanPopupWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_window)

        // Human popup window implementation
        //Display the human win message
        val message = findViewById<TextView>(R.id.textView13)

        //Display the human score
        val messageScore = findViewById<TextView>(R.id.textView14)

        //back button to the message
        val back = findViewById<Button>(R.id.button3)

        //Retrieving data from another activity
        val human = intent.getStringExtra("human")
        val humanScore = intent.getIntExtra("human score",0)

        val totalHumanWins = intent.getIntExtra("humWins",0)
        val totalComputerWins = intent.getIntExtra("comWins",0)

        message.text = human.toString()
        messageScore.text = humanScore.toString()

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("totalHumanWins",totalHumanWins)
            intent.putExtra("totalComputerWins",totalComputerWins)
            startActivity(intent)
        }
    }
}
