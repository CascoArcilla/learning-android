package com.cascoArcilla.courseadroid.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity.Companion.KEY_IMC

class ResultIMCActivity : AppCompatActivity() {
    private var imc: Float = 0.0f

    private lateinit var tvResultImcNumber: TextView
    private lateinit var btnBackCalculatorImc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        initComponents()
        addListeners()
        showNumberImc()
    }

    private fun initComponents() {
        imc = intent.extras?.getFloat(KEY_IMC) ?: -1.0f
        tvResultImcNumber = findViewById(R.id.tvResultImcNumber)
        btnBackCalculatorImc = findViewById(R.id.btnBackImcCalculator)
    }

    private fun addListeners() {
        btnBackCalculatorImc.setOnClickListener {
            var intentBackToImc = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intentBackToImc)
        }
    }

    private fun showNumberImc() {
        tvResultImcNumber.text = imc.toString()
    }
}