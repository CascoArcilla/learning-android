package com.cascoArcilla.courseadroid.imcapp

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.cascoArcilla.courseadroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var clContainer: ConstraintLayout

    private lateinit var viewMale: CardView
    private lateinit var viewFamale: CardView
    private var isMaleSelected: Boolean = true

    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var etWeight: EditText
    private lateinit var btnLessWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private var personWeight: Int = 60

    private lateinit var etAge: EditText
    private lateinit var btnLessAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private var personAge: Int = 22

    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        addListeners()
        initUi()
    }

    private fun initComponents() {
        clContainer = findViewById(R.id.clContainer)

        viewMale = findViewById(R.id.viewMale)
        viewFamale = findViewById(R.id.viewFemale)

        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)

        etWeight = findViewById(R.id.etWeight)
        btnLessWeight = findViewById(R.id.btnLessWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)

        etAge = findViewById(R.id.etAge)
        btnLessAge = findViewById(R.id.btnLessAge)
        btnAddAge = findViewById(R.id.btnAddAge)

        buttonCalculate = findViewById(R.id.btnCalculate)
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

        btnLessWeight.setOnClickListener {
            alterWeight(true)
        }

        btnAddWeight.setOnClickListener {
            alterWeight(false)
        }

        btnLessAge.setOnClickListener {
            alterAge(true)
        }
        btnAddAge.setOnClickListener {
            alterAge(false)
        }

        buttonCalculate.setOnClickListener {
            calculateImc()
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

    private fun alterWeight(isLess: Boolean) {
        var actualWeight = etWeight.text.toString()
        this.personWeight = if (isLess) actualWeight.toInt() - 1 else actualWeight.toInt() + 1
        edithWight()
    }

    private fun edithWight() {
        var newEditWeight = Editable.Factory.getInstance().newEditable(this.personWeight.toString())
        this.etWeight.text = newEditWeight
    }

    private fun alterAge(isLess: Boolean) {
        var actualAge = this.etAge.text.toString()
        this.personAge = if (isLess) actualAge.toInt() - 1 else actualAge.toInt() + 1
        edithAge()
    }

    private fun edithAge() {
        var newEdithAge = Editable.Factory.getInstance().newEditable(this.personAge.toString())
        this.etAge.text = newEdithAge
    }

    private fun calculateImc() {
    }

    private fun initUi() {
        setGanderColor()
        edithWight()
        edithAge()
    }
}
