package com.orionoscode.aac_explore.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.orionoscode.aac_explore.models.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Task")
    fun getTodo() : List<Todo>

    @Query("SELECT * FROM Task WHERE done=1")
    fun getDoneTodo() : LiveData<List<Todo>>

    @Insert
    fun insertAll(vararg todo: Todo)

    @Query("UPDATE Task SET done=1 where id=:id")
    fun updateTodotoDone(id: Int)

    @Query("UPDATE Task SET description=:desc where id=:id")
    fun updateDescription(id: Int, desc: String)

    @Query("SELECT COUNT(*) FROM Task")
    fun countTodo(): Int

}