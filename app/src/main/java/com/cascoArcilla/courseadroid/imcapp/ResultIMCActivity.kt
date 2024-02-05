package com.cascoArcilla.courseadroid.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity.Companion.KEY_IMC

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val imc = intent.extras?.getFloat(KEY_IMC) ?: -1.0f
    }
}