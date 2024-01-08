package com.cascoArcilla.courseadroid.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.cascoArcilla.courseadroid.R

class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        var actualContain: Int = 0

        var showContain = findViewById<TextView>(R.id.tvShowContain)
        this.updateContain(showContain, actualContain)

        val btnIncrement = findViewById<AppCompatButton>(R.id.btnIncremento)
        val btnDecrement = findViewById<AppCompatButton>(R.id.btnDecremento)

        btnIncrement.setOnClickListener {
            actualContain = this.incrementValue(actualContain, true)
            this.updateContain(showContain, actualContain)
        }
    }

    fun updateContain(textView: TextView, value:Int) {
        textView.text = value.toString()
    }

    fun incrementValue(contain: Int, isIncrement: Boolean): Int {
        var newContain: Int = contain
        if (isIncrement) {
            newContain += 1
        } else {
            newContain -= 1
        }
        return newContain
    }
}