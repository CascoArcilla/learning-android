package com.cascoArcilla.courseadroid.takstodo

sealed class ToDoCategory(var isSelect: Boolean = true) {
    object Personal : ToDoCategory()
    object Business : ToDoCategory()
    object Other : ToDoCategory()
}