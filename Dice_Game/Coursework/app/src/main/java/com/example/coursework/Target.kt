package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Target : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        val editText = findViewById<EditText>(R.id.edit_text)
        val ok = findViewById<Button>(R.id.button6)

        ok.setOnClickListener {
            val target = editText.text.toString()
            val value = target.toInt()
            val intent = Intent(this,MainPage::class.java)
            intent.putExtra("target",value)
            startActivity(intent)
        }
    }
}