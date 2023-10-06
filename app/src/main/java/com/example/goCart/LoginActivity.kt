package com.example.goCart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.project1.R

class LoginActivity : AppCompatActivity() {
    //checking git commit,push & pull
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.edit)
        val button: Button = findViewById(R.id.btn)
        val textView: TextView = findViewById(R.id.txtview)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                Toast.makeText(applicationContext, "Invalid Input", Toast.LENGTH_LONG).show()
            } else {
                val doller = editText.text.toString().toInt()
                val rupee = doller * 82
                textView.setText("" + rupee + ".00 ₹")
            }
        }
        onClick()
    }
    fun onClick(){
        val app1: Button = findViewById(R.id.app1)
        app1.setText("SQFT-CENT")

    }
}