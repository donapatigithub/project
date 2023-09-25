package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.project1.R
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.text.DecimalFormat

class EmiCalculator : AppCompatActivity() {

    private lateinit var principalAmountEditText: EditText
    private lateinit var interestRateEditText: EditText
    private lateinit var loanTenureSeekBar: SeekBar
    private lateinit var calculateButton: Button
    private lateinit var emiResultTextView: TextView
    private lateinit var tenureTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emi_calculator)
        // Initialize UI elements
        principalAmountEditText = findViewById(R.id.principalAmountEditText)
        interestRateEditText = findViewById(R.id.interestRateEditText)
        loanTenureSeekBar = findViewById(R.id.loanTenureSeekBar)
        calculateButton = findViewById(R.id.calculateButton)
        emiResultTextView = findViewById(R.id.emiResultTextView)
        tenureTextView = findViewById(R.id.tenureTextView)

        // Add a TextWatcher to format the principal amount with commas
        principalAmountEditText.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Remove commas and format the principal amount
            val principalAmountStr = s.toString().replace(",", "")
            val principalAmount = if (principalAmountStr.isNotEmpty()) {
            principalAmountStr.toDouble()
            } else {
             0.0
            }

            // Format and set the principal amount back in the EditText
            val formattedPrincipalAmount = DecimalFormat("##,##,###.##").format(principalAmount)
            principalAmountEditText.removeTextChangedListener(this)
            principalAmountEditText.setText(formattedPrincipalAmount)
            principalAmountEditText.setSelection(formattedPrincipalAmount.length)
            principalAmountEditText.addTextChangedListener(this)
            }
            })

        // Set up the SeekBar for loan tenure
        loanTenureSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            tenureTextView.text = "Loan Tenure: $progress years"
            }

             override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

        // Set a click listener for the calculate button
        calculateButton.setOnClickListener {
        calculateEMI()
        }
        }

    private fun calculateEMI() {
    val principalAmountStr = principalAmountEditText.text.toString().replace(",", "")
    val principalAmount = if (principalAmountStr.isNotEmpty()) {
        principalAmountStr.toDouble()
        } else {
        0.0
        }

        val annualInterestRate = interestRateEditText.text.toString().toDouble()
        val loanTenure = loanTenureSeekBar.progress

        val monthlyInterestRate = annualInterestRate / 12 / 100
        val n = loanTenure * 12 // Total number of payments

        val emi = (principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, n.toDouble())) /
        (Math.pow(1 + monthlyInterestRate, n.toDouble()) - 1)

        val roundedEMI = Math.round(emi).toInt()

        emiResultTextView.text = "EMI: $roundedEMI"
    }
}