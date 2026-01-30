package com.example.chadformfitness.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabase.runInTransaction
import com.example.chadformfitness.database.dao.WorkoutSessionDao
import com.example.chadformfitness.database.entity.WorkoutSession
import com.example.chadformfitness.database.entity.WorkoutSet
import com.example.chadformfitness.database.entity.WorkoutType

@Database(entities = [
    WorkoutSession::class,
    WorkoutType::class,
    WorkoutSet::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun workoutSessionDao(): WorkoutSessionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "chadform_fitness_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()

                instance
                INSTANCE = instance
                instance
            }
        }

        private fun populateInitialData() {

        }
    }
}