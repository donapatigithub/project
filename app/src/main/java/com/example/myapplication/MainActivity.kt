package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.project1.R

class MainActivity : AppCompatActivity() {
    //checking git commit,push & pull
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val welcome: TextView = findViewById(R.id.welcome)
        val editText: EditText = findViewById(R.id.edit)
        val button: Button = findViewById(R.id.btn)
        val textView: TextView = findViewById(R.id.txtview)

        button.setOnClickListener {
            val doller = editText.text.toString().toDouble()
            val rupee = doller * 82.16
            textView.text = rupee.toString()

        }
    }
}