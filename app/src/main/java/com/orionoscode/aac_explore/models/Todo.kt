package com.orionoscode.aac_explore.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Task")
data class Todo(
        @PrimaryKey(autoGenerate = true) val id: Long,
        var tittle: String = "",
        var subTitle: String = "",
        var description: String ="",
        var done: Int = 0
)