package com.cascoArcilla.courseadroid.imcapp

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.cascoArcilla.courseadroid.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFamale: CardView
    private var isMaleSelected: Boolean = true
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        addListeners()
        initUi()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFamale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun addListeners() {
        viewMale.setOnClickListener {
            changeGender(true)
            setGanderColor()
        }
        viewFamale.setOnClickListener {
            changeGender(false)
            setGanderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val demicalFormat = DecimalFormat("#.##")
            val result = demicalFormat.format(value)
            tvHeight.text = "$result cm"
        }
    }

    private fun changeGender(isTouchMale: Boolean) {
        this.isMaleSelected = isTouchMale
    }

    private fun setGanderColor() {
        viewMale.setCardBackgroundColor(getColorSelect(this.isMaleSelected))
        viewFamale.setCardBackgroundColor(getColorSelect(!this.isMaleSelected))
    }

    private fun getColorSelect(isSelectComponent: Boolean): Int {
        var colorReferens = if (isSelectComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReferens)
    }

    private fun initUi() {
        setGanderColor()
    }
}