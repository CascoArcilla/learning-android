package com.cascoArcilla.courseadroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.cascoArcilla.courseadroid.contador.ContainerActivity
import com.cascoArcilla.courseadroid.firstapp.FirstAppActivity
import com.cascoArcilla.courseadroid.herosapp.HeroListActivity
import com.cascoArcilla.courseadroid.imcapp.ImcCalculatorActivity
import com.cascoArcilla.courseadroid.takstodo.TasksToDoActivity

class MenuActivity : AppCompatActivity() {
    private val APPS = listOf<String>("saludo", "imc", "contador", "tareas", "superheroes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonAppSaludar = findViewById<Button>(R.id.btnAppSaludo)
        buttonAppSaludar.setOnClickListener { navigateTo(APPS[0]) }

        val buttonAppImc = findViewById<Button>(R.id.btnAppImc)
        buttonAppImc.setOnClickListener { navigateTo(APPS[1]) }

        val buttonAppContainer = findViewById<Button>(R.id.btnToAppContainer)
        buttonAppContainer.setOnClickListener { navigateTo(APPS[2]) }

        val buttonAppTaks = findViewById<Button>(R.id.btnToTasks)
        buttonAppTaks.setOnClickListener { navigateTo(APPS[3]) }

        val buttonHeroList = findViewById<Button>(R.id.btnToHeroApp)
        buttonHeroList.setOnClickListener { navigateTo(APPS[4]) }

    }

    private fun navigateTo(app: String) {
        var intent: Intent

        when (app) {
            APPS.get(0) -> {
                intent = Intent(this, FirstAppActivity::class.java)
                startActivity(intent)
            }

            APPS.get(1) -> {
                intent = Intent(this, ImcCalculatorActivity::class.java)
                startActivity(intent)
            }

            APPS.get(2) -> {
                intent = Intent(this, ContainerActivity::class.java)
                startActivity(intent)
            }

            APPS.get(3) -> {
                intent = Intent(this, TasksToDoActivity::class.java)
                startActivity(intent)
            }

            APPS.get(4) -> {
                intent = Intent(this, HeroListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}