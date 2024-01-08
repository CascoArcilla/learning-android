package com.cascoArcilla.courseadroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.cascoArcilla.courseadroid.firstapp.FirstAppActivity
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    private val APPS = listOf<String>("saludo", "imc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonAppSaludar = findViewById<Button>(R.id.btnAppSaludo)
        buttonAppSaludar.setOnClickListener { navigateTo(APPS[0]) }

        val buttonAppImc = findViewById<Button>(R.id.btnAppImc)
        buttonAppImc.setOnClickListener { navigateTo(APPS[1]) }
    }

    private fun navigateTo(app:String){
        var intent : Intent

        when(app){
            APPS.get(0) -> intent = Intent(this, FirstAppActivity::class.java)
            APPS.get(1) -> intent = Intent(this, ImcCalculatorActivity::class.java)
        }

        startActivity(intent)
    }
}