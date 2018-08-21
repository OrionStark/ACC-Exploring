package com.orionoscode.aac_explore.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import com.orionoscode.aac_explore.room.RoomAppDataSource

class TodoViewModel(application: Application) : ViewModel() {
    val DAO = RoomAppDataSource.getAppDatabase(application).todoDao()
    fun getTaskList() = DAO.getTodo()
    fun countTasks() = DAO.countTodo()
    fun updateTask(id: Int) = DAO.updateTodotoDone(id)
}