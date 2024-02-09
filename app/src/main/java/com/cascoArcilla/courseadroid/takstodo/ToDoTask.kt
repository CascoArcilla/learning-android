package com.cascoArcilla.courseadroid.takstodo

data class ToDoTask(val name: String, val category: ToDoCategory, var isSelected: Boolean = false)