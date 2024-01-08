package com.cascoArcilla.courseadroid.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.cascoArcilla.courseadroid.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        // Se llama al arrancar la pantalla
        val btnPushMe = findViewById<AppCompatButton>(R.id.btnPushMe)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btnPushMe.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("extra_name", name)
                startActivity(intent)
            }else{
                Log.i("message", "No hay nombre")
            }

        }
    }
}