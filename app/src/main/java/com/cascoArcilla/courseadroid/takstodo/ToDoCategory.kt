package com.cascoArcilla.courseadroid.takstodo

sealed class ToDoCategory {
    object Personal : ToDoCategory()
    object Business : ToDoCategory()
    object Other : ToDoCategory()
}