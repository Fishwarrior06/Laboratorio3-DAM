package com.example.taskmasterkotlin.data

object TaskManager {
    private val tasks = mutableListOf<Task>()

    //Funcion con parametro variable y lambda
    fun addTasks(vararg newTasks: Task, onSuccess: () -> Unit) {
        tasks.addAll(newTasks.toList())
        onSuccess()
    }

    //Funcion de orden superior con filter
    fun filterTasks(predicate: (Task) -> Boolean): List<Task> {
        return tasks.filter(predicate)
    }

    //Manejo de posible Null con operador ?.
    fun findTaskById(id:Int): Task? = tasks.find {it.id == id}

    //Actualizar estado de la tarea
    fun completeTask(id: Int) {
        val task = findTaskById(id)?:throw IllegalArgumentException("ID $id no existe")
        task.isCompleted = true
    }
}