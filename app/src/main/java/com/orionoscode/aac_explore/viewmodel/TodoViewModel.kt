package com.orionoscode.aac_explore.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.orionoscode.aac_explore.models.Todo
import com.orionoscode.aac_explore.room.RoomAppDataSource

class TodoViewModel constructor(application: Application) : ViewModel() {
    val DAO = RoomAppDataSource.getAppDatabase(application).todoDao()
    fun getTaskList() = DAO.getTodo()
    fun countTasks() = DAO.countTodo()
    fun updateTask(id: Int) = DAO.updateTodotoDone(id)

    val createTestData = {
        val todo = Todo(tittle = "Gaming", subTitle = "With Friends", description = "Clear all the problems", done = 0)
        DAO.insertAll(todo)
        Log.d("USER", todo.tittle)
    }
}