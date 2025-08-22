package com.example.taskmasterkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.taskmasterkotlin.data.Task
import com.example.taskmasterkotlin.data.TaskManager

class MainActivity : AppCompatActivity() {
    private lateinit var tvTasks: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTasks = findViewById(R.id.tvTasks)
        val btnAdd =  findViewById<Button>(R.id.btnCompleteTask)
        //1. Agregar Tareas de ejemplo
        btnAdd.setOnClickListener {
            TaskManager.addTasks(
                Task(1, "Estudiar Kotlin", "Completar actividad practica"),
                Task(2, "Revisar Null Safety"),
                Task(3,"Practicar colecciones")
            ){
                showTasks()
                Toast.makeText(this,"¡Tareas Agregadas!", Toast.LENGTH_SHORT).show()
            }
        }
        //2. Completar tarea con manejo de errores
        btnAdd.setOnClickListener {
            try{
                TaskManager.completeTask(1)
                showTasks()
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showTasks() {
        val tasks = TaskManager.filterTasks {true} //obtener datos
        tvTasks.text = tasks.joinToString ("\n\n"){
          "${it.id}.${it.title} - ${it.description} (${if(it.isCompleted) "☑" else "⌛"})"
        }
    }
}