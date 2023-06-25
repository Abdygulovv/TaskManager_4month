package com.example.abdygulov_chyngyz_4_month.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.abdygulov_chyngyz_4_month.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}