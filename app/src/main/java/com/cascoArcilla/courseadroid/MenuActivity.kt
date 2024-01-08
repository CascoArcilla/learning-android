package com.cascoArcilla.courseadroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cascoArcilla.courseadroid.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonAppSaludar = findViewById<Button>(R.id.btnAppSaludo)
        buttonAppSaludar.setOnClickListener { navigateToSaludarApp() }
    }

    fun navigateToSaludarApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}