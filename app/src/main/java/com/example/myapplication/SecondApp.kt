package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.project1.R

class SecondApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_app)
        val textView:TextView=findViewById(R.id.tv)
        val editText:TextView=findViewById(R.id.et)
        val button:Button=findViewById(R.id.bt)
        val buttonback:Button=findViewById(R.id.back)
        buttonback.setOnClickListener {
            finish()
        }
        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                Toast.makeText(applicationContext, "Invalid Input", Toast.LENGTH_LONG).show()
            } else {
                val sqft = editText.text.toString().toFloat()
                val cent = sqft * 0.002296
                textView.setText("" + cent)
            }
        }
    }
}