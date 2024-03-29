package com.cascoArcilla.courseadroid.takstodo.taskslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.takstodo.ToDoTask
import com.cascoArcilla.courseadroid.R

class TasksAdapter(
    var tasks: List<ToDoTask>,
    private val changeTaskSelcted: (Int) -> Unit
) :
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener { changeTaskSelcted(position) }
    }
}