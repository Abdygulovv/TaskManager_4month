package com.example.abdygulov_chyngyz_4_month.data.local.db

import androidx.room.*
import com.example.abdygulov_chyngyz_4_month.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task>

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

}