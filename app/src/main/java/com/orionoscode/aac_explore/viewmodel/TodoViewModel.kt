package com.orionoscode.aac_explore.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.orionoscode.aac_explore.models.Todo
import com.orionoscode.aac_explore.room.RoomAppDataSource
import org.jetbrains.anko.doAsync

class TodoViewModel constructor(application: Application) : ViewModel() {
    val DAO = RoomAppDataSource.getAppDatabase(application).todoDao()
    val tmp: MutableLiveData<List<Todo>> = MutableLiveData()
    fun getTasks(): LiveData<List<Todo>> {
        doAsync {
            tmp.postValue(DAO.getTodo())
        }
        return tmp
    }

    fun completeTodo(id: Int) {
        doAsync {
            DAO.updateTodotoDone(id = id)
            tmp.postValue(DAO.getTodo())
        }
    }

    fun changeDescription(id: Int, desc: String) {
        doAsync {
            DAO.updateDescription(id, desc)
            tmp.postValue(DAO.getTodo())
        }
    }

    val createTestData = {
        val todo = Todo(tittle = "Gaming", subTitle = "With Friends", description = "Clear all the problems", done = 0)
        DAO.insertAll(todo)
        Log.d("USER", todo.tittle)
    }
}