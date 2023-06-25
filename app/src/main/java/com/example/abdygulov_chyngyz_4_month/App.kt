package com.example.abdygulov_chyngyz_4_month

import android.app.Application
import androidx.room.Room
import com.example.abdygulov_chyngyz_4_month.data.local.db.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}