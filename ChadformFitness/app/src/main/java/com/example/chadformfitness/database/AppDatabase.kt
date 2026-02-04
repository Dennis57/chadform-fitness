package com.example.chadformfitness.database

import android.content.Context
import androidx.activity.result.launch
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chadformfitness.database.dao.WorkoutSessionDao
import com.example.chadformfitness.database.dao.WorkoutSetDao
import com.example.chadformfitness.database.dao.WorkoutTypeDao
import com.example.chadformfitness.database.entity.WorkoutSession
import com.example.chadformfitness.database.entity.WorkoutSet
import com.example.chadformfitness.database.entity.WorkoutType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [
    WorkoutSession::class,
    WorkoutType::class,
    WorkoutSet::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun workoutSessionDao(): WorkoutSessionDao
    abstract fun workoutTypeDao(): WorkoutTypeDao
    abstract fun workoutSetDao(): WorkoutSetDao

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

                INSTANCE = instance

                CoroutineScope(Dispatchers.IO).launch {
                    populateInitialData(instance)
                }

                instance
            }
        }

        private suspend fun populateInitialData(db: AppDatabase) {
            val workoutSessionDao = db.workoutSessionDao()
            val workoutTypeDao = db.workoutTypeDao()
            val workoutSetDao = db.workoutSetDao()

            if (workoutSessionDao.getAll().isEmpty()) {
                db.runInTransaction {
                    workoutSessionDao.insert(WorkoutSession(1, "Leg Day", "Red"))
                    workoutSessionDao.insert(WorkoutSession(2, "Arm Day", "Blue"))
                    workoutSessionDao.insert(WorkoutSession(3, "Core Day", "Green"))
                    workoutSessionDao.insert(WorkoutSession(4, "Cardio", "Yellow"))

                    workoutTypeDao.insert(WorkoutType(1, 1, "Leg Press"))
                    workoutTypeDao.insert(WorkoutType(2, 1, "Leg Extensions"))
                    workoutTypeDao.insert(WorkoutType(3, 1, "Leg Curls"))
                    workoutTypeDao.insert(WorkoutType(4, 2, "Arm Press"))
                    workoutTypeDao.insert(WorkoutType(5, 2, "Arm Extensions"))
                    workoutTypeDao.insert(WorkoutType(6, 2, "Arm Curls"))
                    workoutTypeDao.insert(WorkoutType(7, 3, "Core Day"))
                    workoutTypeDao.insert(WorkoutType(8, 4, "Cardio"))
                }
            }
        }
    }
}