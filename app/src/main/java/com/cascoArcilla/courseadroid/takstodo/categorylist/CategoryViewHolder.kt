package com.cascoArcilla.courseadroid.takstodo.categorylist

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory
import com.cascoArcilla.courseadroid.R

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategory: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.divider)

    fun render(category: ToDoCategory) {
        when(category) {
            ToDoCategory.Business -> {
                tvCategory.text = "Negocios"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_business_category)
                )
            }
            ToDoCategory.Other -> {
                tvCategory.text = "Otros"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_other_category)
                )
            }
            ToDoCategory.Personal -> {
                tvCategory.text = "Personal"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_personal_category)
                )
            }
        }
    }
}