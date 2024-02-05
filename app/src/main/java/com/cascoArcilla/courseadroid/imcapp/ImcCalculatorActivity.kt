package com.cascoArcilla.courseadroid.imcapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
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
    private var personHeight: Float = 150f
    private var personWeight: Int = 60
    private var personAge: Int = 22

    private lateinit var clContainer: ConstraintLayout

    private lateinit var viewMale: CardView
    private lateinit var viewFamale: CardView
    private var isMaleSelected: Boolean = true

    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var etWeight: EditText
    private lateinit var btnLessWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton

    private lateinit var etAge: EditText
    private lateinit var btnLessAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton

    private lateinit var buttonCalculate: Button

    companion object {
        const val KEY_IMC = "RESULT_IMC"
    }

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
            edithHeight(value)
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
            var imc = calculateImc()
            navigateToResult(imc)
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

    private fun edithHeight(value: Float) {
        val demicalFormat = DecimalFormat("#.##")
        val result = demicalFormat.format(value)
        personHeight = value
        rsHeight.setValues(value)
        tvHeight.text = "$result cm"
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

    private fun calculateImc(): Float {
        var df = DecimalFormat("#.##")
        var weight = etWeight.text.toString()
        var heigthM = personHeight / 100;
        var result = weight.toFloat() / (heigthM * heigthM)
        var imc = df.format(result)
        return imc.toFloat()
        //Log.i("resultados", "El IMC es de $imc")
    }

    private fun navigateToResult(imc: Float) {
        var intentResultIMC = Intent(this, ResultIMCActivity::class.java)
        intentResultIMC.putExtra(KEY_IMC, imc)
        startActivity(intentResultIMC)
    }

    private fun initUi() {
        setGanderColor()
        edithHeight(personHeight)
        edithWight()
        edithAge()
    }
}
