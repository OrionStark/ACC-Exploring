package com.orionoscode.aac_explore.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.orionoscode.aac_explore.dao.TodoDao
import com.orionoscode.aac_explore.models.Todo

@Database(entities = [(Todo::class)], version = 1)
abstract class RoomAppDataSource : RoomDatabase() {
    abstract fun todoDao() : TodoDao
    companion object {
        private var DB_INSTANCE: RoomAppDataSource? = null

        fun getAppDatabase(context: Context): RoomAppDataSource {
            if ( DB_INSTANCE == null ) {
                synchronized(this) {
                    DB_INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            RoomAppDataSource::class.java,
                            "TodoAppDB"
                    ).build()
                }
            }
            return DB_INSTANCE as RoomAppDataSource
        }

        fun shutdownTransaction() {
            DB_INSTANCE = null
        }
    }
}