package com.example.chadformfitness.ui.activity

import android.app.Application
import com.example.chadformfitness.database.AppDatabase

class AppActivity : Application() {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        database
    }

}