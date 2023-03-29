package com.example.coursework
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGame = findViewById<Button>(R.id.button1)
        val about = findViewById<Button>(R.id.button2)
        val rules = findViewById<Button>(R.id.button7)

        val humanWinsCount = intent.getIntExtra("totalHumanWins",0)
        val computerWinsCount = intent.getIntExtra("totalComputerWins",0)

        //new game button
        newGame.setOnClickListener {
            val intent = Intent(this,MainPage::class.java)
            intent.putExtra("humanWinsCount",humanWinsCount)
            intent.putExtra("computerWinsCount",computerWinsCount)
            startActivity(intent)
        }

        //about button
        about.setOnClickListener {

            //About page details
            val name = "Name : Surendran Mayuran"
            val studentId = "Student Id : 20211159"
            val description = "I confirm that I understand what plagiarism is and have read and " +
                    "understood the section on Assessment Offences in the Essential Information for " +
                    "Students. The work that I have submitted is entirely my own. Any work from other " +
                    "authors is duly referenced and acknowledged."
            val message = name +"\n"+studentId+"\n"+ "\n"+description

            //set title to the center
            val title = TextView(this)
            title.setText(R.string.Details)
            title.gravity = Gravity.CENTER
            title.textSize = 20f
            title.setTextColor(Color.BLACK)
            title.setTypeface(null,Typeface.BOLD)

            val aboutPopup = AlertDialog.Builder(this)
            aboutPopup.setCustomTitle(title)
            aboutPopup.setMessage(message)
            val aboutDialog = aboutPopup.create()
            aboutDialog.show()

            // Set the background color of the dialog
            val aboutWindow = aboutDialog.window
            aboutWindow?.setBackgroundDrawable(ColorDrawable(Color.LTGRAY))
        }
        rules.setOnClickListener {
            val title = TextView(this)
            title.setText(R.string.The_rules_of_the_game)
            title.gravity = Gravity.CENTER
            title.textSize = 20f
            title.setTypeface(null,Typeface.BOLD)
            title.setTextColor(Color.BLACK)

            val message = "A human player competes against the computer. Both players throw 5 dice at the same time. " +
                    "The score of each throw for each player is the sum of the numbers shown on the faces of the " +
                    "dice. The objective of the game is to reach a score of 101 or more (instead of 101 another target " +
                    "can be set by the human before play starts) by throwing 5 dice as many times as necessary. \n" +
                    "\nAfter a roll, each player may either score it or take up to two optional reRolls. For each reRoll, " +
                    "they may reRoll all of the dice or select any of the dice to keep and only reRoll the remainder. " +
                    "A player may score at any time, thus ending their current throw; after the second reRoll (three " +
                    "rolls in total) they must score it. \n" +
                    "\nAfter both players score their rolls, the procedure is repeated until one of the players reach " +
                    "101 or more points by summing all of their scores. If both players reach 101 or more with " +
                    "the same number of attempts (a single attempt is considered as one roll followed by 2 optional " +
                    "reRolls) the player with the highest score wins.\n" +
                    "\nAs an example, assume that the human player scores 30 points in the first attempt (a roll " +
                    "followed by 2 optional reRolls), 25 in the second, 11 in the third, 28 in the fourth and 15 in " +
                    "the fifth achieving a total score of 109 in five attempts. If the computer did not score 101 in " +
                    "four attempts or more than 109 in five attempts, the human wins. \n" + "\nIn the case that both the " +
                    "computer and the human achieved the same score in the five attempts (i.e. 109 in the example), " +
                    "each player throws for a last time all five dice and the player with the highest sum in that roll " +
                    "wins (no optional reRolls are allowed in this case). In the case of a tie again, both players keep " +
                    "rethrowing all five dice until one of them wins. "
            val rulesPopup = AlertDialog.Builder(this)
            rulesPopup.setCustomTitle(title)
            rulesPopup.setMessage(message)
            val rulesDialog = rulesPopup.create()
            rulesDialog.show()

            // Set the background color of the dialog
            val rulesWindow = rulesDialog.window
            rulesWindow?.setBackgroundDrawable(ColorDrawable(Color.CYAN))
        }
    }

}