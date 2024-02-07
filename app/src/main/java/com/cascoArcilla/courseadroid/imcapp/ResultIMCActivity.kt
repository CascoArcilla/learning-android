package com.cascoArcilla.courseadroid.imcapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity.Companion.KEY_IMC

class ResultIMCActivity : AppCompatActivity() {
    private var imc: Float = 0.0f

    private lateinit var tvResultImcText: TextView
    private lateinit var tvResultImcNumber: TextView
    private lateinit var tvMesageImc: TextView
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
        showMessageImc()
    }

    private fun initComponents() {
        imc = intent.extras?.getFloat(KEY_IMC) ?: -1.0f
        tvResultImcText = findViewById(R.id.tvResultImcText)
        tvResultImcNumber = findViewById(R.id.tvResultImcNumber)
        tvMesageImc = findViewById(R.id.tvMessageImc)
        btnBackCalculatorImc = findViewById(R.id.btnBackImcCalculator)
    }

    private fun addListeners() {
        btnBackCalculatorImc.setOnClickListener { onBackPressed() }
    }

    private fun showNumberImc() {
        tvResultImcNumber.text = imc.toString()
    }

    private fun showTextImc() {
        val type_weight = getTypeImc()
        setColorResultText(type_weight)
        tvResultImcText.text = type_weight
    }

    private fun showMessageImc(){
        val type_weight = getTypeImc()
        setMessageTextImc(type_weight)
    }

    private fun getTypeImc(): String {
        when {
            imc < WEIGHT_LOW -> return TYPE_WEIGHT[0]
            WEIGHT_NORMAL[0] <= imc && imc <= WEIGHT_NORMAL[1] -> return TYPE_WEIGHT[1]
            WEIGHT_HIGH[0] <= imc && imc <= WEIGHT_HIGH[1] -> return TYPE_WEIGHT[2]
            imc >= WEIGHT_VERY_HIGH -> return TYPE_WEIGHT[3]
            else -> return ""
        }
    }

    private fun setColorResultText(weight: String) {
        when (weight) {
            TYPE_WEIGHT[0] -> {
                var colorText = ContextCompat.getColor(this, R.color.peso_bajo)
                tvResultImcText.setTextColor(colorText)
            }

            TYPE_WEIGHT[1] -> {
                var colorText = ContextCompat.getColor(this, R.color.peso_normal)
                tvResultImcText.setTextColor(colorText)
            }

            TYPE_WEIGHT[2] -> {
                var textColor = ContextCompat.getColor(this, R.color.peso_sobrepeso)
                tvResultImcText.setTextColor(textColor)
            }

            TYPE_WEIGHT[3] -> {
                var textColor = ContextCompat.getColor(this, R.color.obesidad)
                tvResultImcText.setTextColor(textColor)
            }
        }
    }

    private fun setMessageTextImc(weight: String) {
        when (weight) {
            TYPE_WEIGHT[0] -> tvMesageImc.text = getString(R.string.message_low_weight)
            TYPE_WEIGHT[1] -> tvMesageImc.text = getString(R.string.message_normal_weight)
            TYPE_WEIGHT[2] -> tvMesageImc.text = getString(R.string.message_high_weight)
            TYPE_WEIGHT[3] -> tvMesageImc.text = getString(R.string.message_very_high_weight)
        }
    }
}