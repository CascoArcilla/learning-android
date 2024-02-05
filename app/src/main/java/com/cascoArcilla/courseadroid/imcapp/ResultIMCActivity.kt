package com.cascoArcilla.courseadroid.imcapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity.Companion.KEY_IMC

class ResultIMCActivity : AppCompatActivity() {
    private var imc: Float = 0.0f

    private lateinit var tvResultImcText : TextView
    private lateinit var tvResultImcNumber: TextView
    private lateinit var btnBackCalculatorImc: Button

    companion object {
        const val WEIGHT_LOW: Float = 18.5f
        val WEIGHT_NORMAL: List<Float> = listOf(18.5f, 24.9f)
        val WEIGHT_HIGH: List<Float> = listOf(25.0f, 29.9f)
        const val WEIGHT_VERY_HIGH: Float = 30.0f
        val TYPE_WEIGHT: List<String> =
            listOf("Peso bajo", "Peso normal", "Sobrepeso", "Obesidad")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        initComponents()
        addListeners()
        showNumberImc()
        showTextImc()
    }

    private fun initComponents() {
        imc = intent.extras?.getFloat(KEY_IMC) ?: -1.0f
        tvResultImcText = findViewById(R.id.tvResultImcText)
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

    private fun showTextImc() {
        val type_weight = getCompareImc()
        tvResultImcText.text = type_weight
    }

    private fun getCompareImc(): String {
        when {
            imc < WEIGHT_LOW -> {
                var colorText = ContextCompat.getColor(this, R.color.peso_bajo)
                tvResultImcText.setTextColor(colorText)
                return TYPE_WEIGHT[0]
            }
            WEIGHT_NORMAL[0] <= imc && imc <= WEIGHT_NORMAL[1] -> {
                var colorText = ContextCompat.getColor(this, R.color.peso_normal)
                tvResultImcText.setTextColor(colorText)
                return TYPE_WEIGHT[1]
            }
            WEIGHT_HIGH[0] <= imc && imc <= WEIGHT_HIGH[1] -> {
                var textColor = ContextCompat.getColor(this, R.color.peso_sobrepeso)
                tvResultImcText.setTextColor(textColor)
                return TYPE_WEIGHT[2]
            }
            imc >= WEIGHT_VERY_HIGH -> {
                var textColor = ContextCompat.getColor(this, R.color.obesidad)
                tvResultImcText.setTextColor(textColor)
                return TYPE_WEIGHT[3]
            }
            else -> return ""
        }
    }
}