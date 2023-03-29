package com.example.coursework
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainPage : AppCompatActivity() {
    private var humanScore = 0
    private var computerScore = 0
    private var attempt = 1
    private var count = 10
    private var target = readLine()?.toIntOrNull() ?: 101
    private var humanWins = 0
    private var computerWins = 0
    private val userImageView = listOf(R.id.imageView, R.id.imageView2, R.id.imageView3,
        R.id.imageView4, R.id.imageView5)
    private var humanFirstDice: Int = 0
    private var humanSecondDice: Int = 0
    private var humanThirdDice: Int = 0
    private var humanFourthDice: Int = 0
    private var humanFifthDice: Int = 0
    private var computerFirstDice:Int = 0
    private var computerSecondDice:Int = 0
    private var computerThirdDice :Int =0
    private var computerFourthDice :Int =0
    private var computerFifthDice: Int = 0
    private var humanReRolls = 2
    private var computerReRolls = 2
    private var example1:Int = -1
    private var example2:Int = -1
    private var example3: Int= -1
    private var computerRandom = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        //Retrieve instance state data
        if (savedInstanceState != null) {
            humanWins = savedInstanceState.getInt("humanWins",0)
        }
        if (savedInstanceState != null) {
            computerWins = savedInstanceState.getInt("computerWins",0)
        }
        if (savedInstanceState != null) {
            humanScore = savedInstanceState.getInt("humanScore",0)
        }
        if (savedInstanceState != null) {
            computerScore = savedInstanceState.getInt("computerScore",0)
        }
        if (savedInstanceState != null) {
            target = savedInstanceState.getInt("target",0)
        }

        if (savedInstanceState != null) {
            example1 = savedInstanceState.getInt("computerRandomNumber1",-1)
        }

        if (savedInstanceState != null) {
            example2 = savedInstanceState.getInt("computerRandomNumber2",-1)
        }

        if (savedInstanceState != null) {
            example3 = savedInstanceState.getInt("computerRandomNumber3",-1)
        }

        if (savedInstanceState != null) {
            attempt = savedInstanceState.getInt("attempt",0)
        }

        if (savedInstanceState != null) {
            humanFirstDice = savedInstanceState.getInt("humanFirstDice",0)
        }

        if (savedInstanceState != null) {
            humanSecondDice = savedInstanceState.getInt("humanSecondDice",0)
        }

        if (savedInstanceState != null) {
            humanThirdDice = savedInstanceState.getInt("humanThirdDice",0)
        }

        if (savedInstanceState != null) {
            humanFourthDice = savedInstanceState.getInt("humanFourthDice",0)
        }

        if (savedInstanceState != null) {
            humanFifthDice = savedInstanceState.getInt("humanFifthDice",0)
        }

        if (savedInstanceState != null) {
            computerFirstDice = savedInstanceState.getInt("computerFirstDice",0)
        }

        if (savedInstanceState != null) {
            computerSecondDice = savedInstanceState.getInt("computerSecondDice",0)
        }

        if (savedInstanceState != null) {
            computerThirdDice = savedInstanceState.getInt("computerThirdDice",0)
        }

        if (savedInstanceState != null) {
            computerFourthDice = savedInstanceState.getInt("computerFourthDice",0)
        }

        if (savedInstanceState != null) {
            computerFifthDice = savedInstanceState.getInt("computerFifthDice",0)
        }

        if (savedInstanceState != null) {
            computerReRolls = savedInstanceState.getInt("computerReRolls",0)
        }

        if (savedInstanceState != null) {
            humanReRolls = savedInstanceState.getInt("humanReRolls",0)
        }

        // Image Views
        val imageView1 = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        val imageView7 = findViewById<ImageView>(R.id.imageView7)
        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        val imageView9 = findViewById<ImageView>(R.id.imageView9)
        val imageView10 = findViewById<ImageView>(R.id.imageView10)

        //image clickable and focusable details saving
        val userList = mutableListOf<Int>()

        // throw button
        val generate = findViewById<Button>(R.id.button)

        //Target button
        val targetButton = findViewById<Button>(R.id.button5)

        //Score Button
        val score = findViewById<Button>(R.id.button2)

        //image array
        val images = arrayOf(
            R.drawable.die_face_1, R.drawable.die_face_2, R.drawable.die_face_3,
            R.drawable.die_face_4, R.drawable.die_face_5, R.drawable.die_face_6)

        //user update target score
        target = intent.getIntExtra("target",100)



        for (i in userImageView) {
            findViewById<ImageView>(i).isClickable = true
            findViewById<ImageView>(i).isFocusable = true
            findViewById<ImageView>(i).setOnClickListener {
                userImageviewSelect(findViewById<ImageView>(i), userList)
            }
        }

        humanWins = intent.getIntExtra("humanWinsCount",0)
        computerWins = intent.getIntExtra("computerWinsCount",0)

        val hWins = findViewById<TextView>(R.id.textView18)
        val cWins = findViewById<TextView>(R.id.textView19)

        hWins.text = "H:".plus(humanWins.toString())
        cWins.text = "C:".plus(computerWins.toString())


        //throw button
        generate.setOnClickListener {
            var reRollsCount = 0
            var computerReRollsCount  =0
            while (attempt <= count) {
                // Human rolling five dices
                //First Dice
                if (!userList.contains(0)) {
                    val id1 = generateRandomNumber()
                    humanScore += id1
                    humanFirstDice = id1
                    var imgNumber1 = id1
                    imgNumber1 -= 1
                    imageView1.setImageResource(images[imgNumber1])
                } else {
                    humanScore += humanFirstDice
                    var userClick1 = humanFirstDice
                    userClick1 -= 1
                    imageView1.setImageResource(images[userClick1])
                    userList.remove(0)
                    imageView1.setBackgroundColor(Color.TRANSPARENT)
                    reRollsCount++
                }

                //Second Dice
                if (!userList.contains(1)) {
                    val id2 = generateRandomNumber()
                    humanScore += id2
                    humanSecondDice = id2
                    var imgNumber2 = id2
                    imgNumber2 -= 1
                    imageView2.setImageResource(images[imgNumber2])
                } else {
                    humanScore += humanSecondDice
                    var userClick1 = humanSecondDice
                    userClick1 -= 1
                    imageView2.setImageResource(images[userClick1])
                    userList.remove(1)
                    imageView2.setBackgroundColor(Color.TRANSPARENT)
                    reRollsCount++
                }

                //Third Dice
                if (!userList.contains(2)) {
                    val id3 = generateRandomNumber()
                    humanScore += id3
                    humanThirdDice = id3
                    var imgNumber3 = id3
                    imgNumber3 -= 1
                    imageView3.setImageResource(images[imgNumber3])
                } else {
                    humanScore += humanThirdDice
                    var userClick1 = humanThirdDice
                    userClick1 -= 1
                    imageView3.setImageResource(images[userClick1])
                    userList.remove(2)
                    imageView3.setBackgroundColor(Color.TRANSPARENT)
                    reRollsCount++
                }

                //Fourth Dice
                if (!userList.contains(3)) {
                    val id4 = generateRandomNumber()
                    humanScore += id4
                    humanFourthDice = id4
                    var imgNumber4 = id4
                    imgNumber4 -= 1
                    imageView4.setImageResource(images[imgNumber4])
                } else {
                    humanScore += humanFourthDice
                    var userClick1 = humanFourthDice
                    userClick1 -= 1
                    imageView4.setImageResource(images[userClick1])
                    userList.remove(3)
                    imageView4.setBackgroundColor(Color.TRANSPARENT)
                    reRollsCount++
                }

                //Fifth Dice
                if (!userList.contains(4)) {
                    val id5 = generateRandomNumber()
                    humanScore += id5
                    humanFifthDice = id5
                    var imgNumber5 = id5
                    imgNumber5 -= 1
                    imageView5.setImageResource(images[imgNumber5])
                } else {
                    humanScore += humanFifthDice
                    var userClick1 = humanFifthDice
                    userClick1 -= 1
                    imageView5.setImageResource(images[userClick1])
                    userList.remove(4)
                    imageView5.setBackgroundColor(Color.TRANSPARENT)
                    reRollsCount++
                }

                //Computer playing five dices

                //Generate random numbers initialized to the variable
                val id6 = generateRandomNumber()
                val id7 = generateRandomNumber()
                val id8 = generateRandomNumber()
                val id9 = generateRandomNumber()
                val id10 = generateRandomNumber()

                for (i in 0..5)
                    when(i){
                        0 -> {
                            if(example1 == 0|| example2 == 0 || example3 == 0 ){
                                var imgNumber6 =computerFirstDice
                                computerScore += computerFirstDice
                                imgNumber6 -= 1
                                imageView6.setImageResource(images[imgNumber6])
                                computerReRollsCount ++
                            }else{
                                computerFirstDice = id6
                                computerScore += computerFirstDice
                                var imgNumber6 = id6
                                imgNumber6 -= 1
                                imageView6.setImageResource(images[imgNumber6])
                            }
                        }
                        1 -> {
                            if(example1 == 1 || example2 == 1 || example3 == 1 ){
                                var imgNumber7 = computerSecondDice
                                computerScore += computerSecondDice
                                imgNumber7 -= 1
                                imageView7.setImageResource(images[imgNumber7])
                                computerReRollsCount ++
                            }else {
                                computerSecondDice = id7
                                computerScore += computerSecondDice
                                var imgNumber7 = id7
                                imgNumber7 -= 1
                                imageView7.setImageResource(images[imgNumber7])
                            }
                        }
                        2->{
                            if(example1 == 2 || example2 == 2 || example3 == 2 ){
                                var imgNumber8 = computerThirdDice
                                computerScore += computerThirdDice
                                imgNumber8 -= 1
                                imageView8.setImageResource(images[imgNumber8])
                                computerReRollsCount ++
                            }else{
                                computerThirdDice = id8
                                computerScore += computerThirdDice
                                var imgNumber8 = id8
                                imgNumber8 -= 1
                                imageView8.setImageResource(images[imgNumber8])
                            }
                        }
                        3->{
                            if(example1 == 3|| example2 == 3 || example3 == 3){
                                var imgNumber9 = computerFourthDice
                                computerScore += computerFourthDice
                                imgNumber9 -= 1
                                imageView9.setImageResource(images[imgNumber9])
                                computerReRollsCount ++
                            }else{
                                computerFourthDice = id9
                                computerScore += computerFourthDice
                                var imgNumber9 = id9
                                imgNumber9 -= 1
                                imageView9.setImageResource(images[imgNumber9])
                            }
                        }
                        4->{
                            if(example1 == 4 || example2 == 4 || example3 == 4){
                                var imgNumber10 = computerFifthDice
                                computerScore += computerFifthDice
                                imgNumber10 -= 1
                                imageView10.setImageResource(images[imgNumber10])
                                computerReRollsCount ++
                            }else{
                                computerFifthDice = id10
                                computerScore += computerFifthDice
                                var imgNumber10 = id10
                                imgNumber10 -= 1
                                imageView10.setImageResource(images[imgNumber10])
                            }
                        }
                    }
                attempt++
                break
            }

//            val generateNumber1 = generateRandomNumberForComputer()
//            val generateNumber2 = generateRandomNumberForComputer()
//            val generateNumber3 = generateRandomNumberForComputer()
//            val generateNumber4 = generateRandomNumberForComputer()
//            val generateNumber5 = generateRandomNumberForComputer()
//
//            val computerImagesFaceValue = listOf(computerFirstDice,computerSecondDice,computerThirdDice,computerFourthDice,computerFirstDice)

            // Human ReRolls Available Count
            if (reRollsCount in 1..6) {
                humanReRolls--
            }

            //Computer ReRolls Available Count
            if (computerReRollsCount in 1..6) {
                computerReRolls --
            }

            //Score automatically update after the attempt number 3
            if (attempt > 3) {
                val hScore = findViewById<TextView>(R.id.textView7)
                val cScore = findViewById<TextView>(R.id.textView12)

                hScore.text = "Human:".plus(humanScore.toString())
                cScore.text = "PC:".plus(computerScore.toString())
            }

            displayWinMessage()

            //Decides randomly whether it would like to reRoll
            if(attempt>1 && computerReRolls>0 ){
                example1 = generateRandomNumberForComputer()
                example2 = generateRandomNumberForComputer()
                example3 = generateRandomNumberForComputer()
                Log.d("computerRandom: ",example1.toString())
                Log.d("computerRandom: ",example2.toString())
                Log.d("computerRandom: ",example3.toString())
                computerRandom = mutableListOf(example1,example2,example3)
            }else {
                example1 = 0
                example2 = 0
                example3 = 0
            }
            //Human Score and computer score equal u can't take reRolls
            if (computerScore == humanScore && (humanScore >100)){
                example1 = 0
                example2 = 0
                example3 = 0
            }

            //Human wins calculate
            humanWins = intent.getIntExtra("humanWinsCount",0)
            computerWins = intent.getIntExtra("computerWinsCount",0)

            val hWins = findViewById<TextView>(R.id.textView18)
            val cWins = findViewById<TextView>(R.id.textView19)

            hWins.text = "H:".plus(humanWins.toString())
            cWins.text = "C:".plus(computerWins.toString())

        }

        //score button
        score.setOnClickListener {
            val hScore = findViewById<TextView>(R.id.textView7)
            val cScore = findViewById<TextView>(R.id.textView12)

            hScore.text = "Human".plus(humanScore.toString())
            cScore.text = "PC:".plus(computerScore.toString())
        }

        //target button
        targetButton.setOnClickListener {
            val intent = Intent(this, Target::class.java)
            startActivity(intent)
        }
    }

    //random number generating
    private fun generateRandomNumber(): Int {
        val number = kotlin.random.Random.nextInt(1, 7)
        if (number in 1..7) {
            return number
        }
        return number
    }

    //Random number generating for reRolls
    private fun generateRandomNumberForComputer(): Int {
        val number = kotlin.random.Random.nextInt(0, 5)
        if (number in 0..5) {
            return number
        }
        return number
    }

    // computer and human win or lose display method
    private fun displayWinMessage() {
        if (humanScore >= target && humanScore > computerScore) {
            humanWins ++

            val hWins = findViewById<TextView>(R.id.textView18)
            hWins.text = "H:".plus(humanWins.toString())
            val cWins = findViewById<TextView>(R.id.textView19)
            cWins.text = "C:".plus(computerWins.toString())

            val intent = Intent(this, HumanPopupWindow::class.java)
            intent.putExtra("human", "You win")
            intent.putExtra("humWins",humanWins)
            intent.putExtra("comWins",computerWins)
            intent.putExtra("human score", humanScore)
            startActivity(intent)
            finish()
        } else if (computerScore >= target && computerScore > humanScore) {
            computerWins++

            val hWins = findViewById<TextView>(R.id.textView18)
            hWins.text = "H:".plus(humanWins.toString())

            val cWins = findViewById<TextView>(R.id.textView19)
            cWins.text = "C:".plus(computerWins.toString())

            val intent = Intent(this, ComputerPopupWindow::class.java)
            intent.putExtra("computer", "You lose")
            intent.putExtra("computer score", computerScore)
            intent.putExtra("comWins",computerWins)
            intent.putExtra("humWins",humanWins)
            startActivity(intent)
            finish()
        }
    }

    // Save instance state data
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("humanWins", humanWins)
        outState.putInt("computerWins", computerWins)
        outState.putInt("humanScore", humanScore)
        outState.putInt("computerScore", computerScore)
        outState.putInt("target",target)
        outState.putInt("computerRandomNumber1",example1)
        outState.putInt("computerRandomNumber2",example2)
        outState.putInt("computerRandomNumber3",example3)
        outState.putInt("attempt",attempt)
        outState.putInt("humanFirstDice",humanFirstDice)
        outState.putInt("humanSecondDice",humanSecondDice)
        outState.putInt("humanThirdDice",humanThirdDice)
        outState.putInt("humanFourthDice",humanFourthDice)
        outState.putInt("humanFifthDice",humanFifthDice)
        outState.putInt("computerFirstDice",computerFirstDice)
        outState.putInt("computerSecondDice",computerSecondDice)
        outState.putInt("computerThirdDice",computerThirdDice)
        outState.putInt("computerFourthDice",computerFourthDice)
        outState.putInt("computerFifthDice",computerFifthDice)
        outState.putInt("computerReRolls",computerReRolls)
        outState.putInt("humanReRolls",humanReRolls)
    }

    //user image select for reRolling
    private fun userImageviewSelect(view: View, imageSelecting:MutableList<Int>){

        if(view.id == R.id.imageView && humanReRolls>0 && (humanScore != computerScore)){
            if(!imageSelecting.contains(0)){
                imageSelecting.add(0)
                view.setBackgroundColor(Color.BLUE)
            }else{
                imageSelecting.remove(0)
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        if(view.id == R.id.imageView2 && humanReRolls>0){
            if(!imageSelecting.contains(1)){
                imageSelecting.add(1)
                view.setBackgroundColor(Color.BLUE)
            }else{
                imageSelecting.remove(1)
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        if(view.id == R.id.imageView3 && humanReRolls>0){
            if(!imageSelecting.contains(2)){
                imageSelecting.add(2)
                view.setBackgroundColor(Color.BLUE)
            }else{
                imageSelecting.remove(2)
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        if(view.id == R.id.imageView4 && humanReRolls>0){
            if(!imageSelecting.contains(3)){
                imageSelecting.add(3)
                view.setBackgroundColor(Color.BLUE)
            }else{
                imageSelecting.remove(3)
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        if(view.id == R.id.imageView5 && humanReRolls>0){
            if(!imageSelecting.contains(4)){
                imageSelecting.add(4)
                view.setBackgroundColor(Color.BLUE)
            }else{
                imageSelecting.remove(4)
                view.setBackgroundColor(Color.TRANSPARENT)
            }
        }

    }
}




