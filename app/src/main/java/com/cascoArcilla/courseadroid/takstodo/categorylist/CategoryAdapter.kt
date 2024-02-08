package com.cascoArcilla.courseadroid.takstodo.categorylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory
import com.cascoArcilla.courseadroid.R

class CategoryAdapter(private val categories: List<ToDoCategory>) :
    RecyclerView.Adapter<CategoryViewHolder>() { // hacermos una clase para el adaptador de la recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder { // motara la vista para que poder ser mostrada, debe haber un vista previamente
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return  CategoryViewHolder(view)
    }

    override fun getItemCount(): Int { //regresa la cantidad de items a mostrar
        return  categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) { // tomara la vista creada por onCreateViweHolder para mostrarla
        holder.render(categories[position])
    }
}