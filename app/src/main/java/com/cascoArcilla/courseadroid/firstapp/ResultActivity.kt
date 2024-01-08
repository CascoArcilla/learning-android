package com.cascoArcilla.courseadroid.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cascoArcilla.courseadroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name:String = intent.extras?.getString("extra_name").orEmpty()

        if (name.isNotEmpty()){
            tvResult.text = "Hola $name o(0_0)d"
        } else  {
            tvResult.text = "¿No tienes nombre? (o_o|)"
        }

    }
}