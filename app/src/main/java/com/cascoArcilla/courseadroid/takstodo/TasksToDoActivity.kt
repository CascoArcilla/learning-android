package com.cascoArcilla.courseadroid.takstodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.takstodo.categorylist.CategoryAdapter

class TasksToDoActivity : AppCompatActivity() {
    private val categories = listOf<ToDoCategory>(
        ToDoCategory.Personal,
        ToDoCategory.Business,
        ToDoCategory.Other
    )

    private lateinit var rvToDoCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks_to_do)
        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvToDoCategory = findViewById(R.id.rvToDoCategorys)
    }

    private fun initUI(){
        categoryAdapter = CategoryAdapter(categories)
        rvToDoCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvToDoCategory.adapter = categoryAdapter
    }
}