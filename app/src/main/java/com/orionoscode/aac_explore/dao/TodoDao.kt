package com.orionoscode.aac_explore.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.orionoscode.aac_explore.models.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Task")
    fun getTodo() : LiveData<ArrayList<Todo>>

    @Query("SELECT * FROM Task WHERE done=1")
    fun getDoneTodo() : LiveData<ArrayList<Todo>>

    @Insert
    fun insertAll(vararg todo: Todo)

    @Query("UPDATE Task SET done=1 where id=:id")
    fun updateTodotoDone(id: Int)

    @Query("SELECT COUNT(*) FROM Task")
    fun countTodo(): Int

}