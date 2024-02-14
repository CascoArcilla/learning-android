package com.cascoArcilla.courseadroid.herosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.databinding.ActivityHeroListBinding

class HeroListActivity : AppCompatActivity() {
    private lateinit var heroListBinding: ActivityHeroListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heroListBinding = ActivityHeroListBinding.inflate(layoutInflater)
        setContentView(heroListBinding.root)
        initUI()
    }

    private fun initUI() {
        heroListBinding.svHeroApp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchHero(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun searchHero(query: String) {

    }
}