package com.jslee.retrofittesting.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (

    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,

    @ColumnInfo(name = "user_name")
    var name: String = "",

    @ColumnInfo(name = "user_age")
    var age: String = ""

)