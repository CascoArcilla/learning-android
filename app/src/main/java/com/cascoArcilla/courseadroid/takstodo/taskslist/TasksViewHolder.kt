package com.cascoArcilla.courseadroid.takstodo.taskslist

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory.Business
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory.Other
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory.Personal
import com.cascoArcilla.courseadroid.takstodo.ToDoTask

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cbToDoTask: CheckBox = view.findViewById(R.id.cbToDoChenkTask)
    private val tvToDoNameTask: TextView = view.findViewById(R.id.tvToDoNameTask)

    fun render(task: ToDoTask) {
        val color = when (task.category) {
            Business -> R.color.todo_business_category
            Other -> R.color.todo_other_category
            Personal -> R.color.todo_personal_category
        }

        if (task.isSelected) {
            cbToDoTask.isChecked = true
            tvToDoNameTask.paintFlags = tvToDoNameTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvToDoNameTask.paintFlags =
                tvToDoNameTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        tvToDoNameTask.text = task.name
        cbToDoTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbToDoTask.context, color)
        )
    }
}