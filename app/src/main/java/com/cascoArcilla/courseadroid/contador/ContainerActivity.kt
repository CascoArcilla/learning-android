package com.cascoArcilla.courseadroid.contador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.cascoArcilla.courseadroid.MenuActivity
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.firstapp.FirstAppActivity

class ContainerActivity : AppCompatActivity() {
    private var actualContain: Int = 0

    private lateinit var showContain: TextView
    private lateinit var btnIncrement: Button
    private lateinit var btnDecrement: Button
    private lateinit var btnMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        initCompoents()
        addListeners()
    }

    fun initCompoents() {
        showContain = findViewById<TextView>(R.id.tvShowContain)
        this.updateContain(showContain, actualContain)

        btnIncrement = findViewById<AppCompatButton>(R.id.btnIncrementoContador)
        btnDecrement = findViewById<AppCompatButton>(R.id.btnDecrementoContador)
        btnMenu = findViewById<AppCompatButton>(R.id.btnMainContador)
    }

    fun addListeners() {
        btnIncrement.setOnClickListener {
            actualContain = this.incrementValue(actualContain, true)
            this.updateContain(showContain, actualContain)
        }

        btnDecrement.setOnClickListener {
            actualContain = this.incrementValue(actualContain, false)
            this.updateContain(showContain, actualContain)
        }

        btnMenu.setOnClickListener {
            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    fun updateContain(textView: TextView, value: Int) {
        textView.text = value.toString()
    }

    fun incrementValue(contain: Int, isIncrement: Boolean): Int {
        var newContain: Int = contain
        if (isIncrement) {
            newContain += 1
        } else if (newContain == 0) {
            return newContain
        } else {
            newContain -= 1
        }
        return newContain
    }
}