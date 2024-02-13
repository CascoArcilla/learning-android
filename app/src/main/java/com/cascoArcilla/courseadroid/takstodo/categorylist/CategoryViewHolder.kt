package com.cascoArcilla.courseadroid.takstodo.categorylist

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory
import com.cascoArcilla.courseadroid.R

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategory: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.divider)
    private val cvToDoItemCategory: CardView = view.findViewById(R.id.cvToDoItemCategory)

    fun render(category: ToDoCategory, changeSelectCategory: (Int) -> Unit) {
        var text: String
        var color: Int
        val colorCard = if (category.isSelect) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        when (category) {
            ToDoCategory.Business -> {
                text = "Negocios"
                color = R.color.todo_business_category
            }

            ToDoCategory.Other -> {
                text = "Otros"
                color = R.color.todo_other_category
            }

            ToDoCategory.Personal -> {
                text = "Personal"
                color = R.color.todo_personal_category
            }
        }

        itemView.setOnClickListener { changeSelectCategory(layoutPosition) }
        cvToDoItemCategory.setCardBackgroundColor(
            ContextCompat.getColor(
                cvToDoItemCategory.context,
                colorCard
            )
        )
        tvCategory.text = text
        vDivider.setBackgroundColor(
            ContextCompat.getColor(vDivider.context, color)
        )
    }
}