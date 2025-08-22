package com.example.taskmasterkotlin.data

data class Task(
    val id: Int,
    val title: String,
    val description: String? = null, //Null Safety
    var isCompleted: Boolean = false
)