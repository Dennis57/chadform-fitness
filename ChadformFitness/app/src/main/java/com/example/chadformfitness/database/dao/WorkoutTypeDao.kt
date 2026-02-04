package com.example.chadformfitness.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.chadformfitness.database.entity.WorkoutType

@Dao
interface WorkoutTypeDao {
    @Query("SELECT * FROM workouttype")
    fun getAll(): List<WorkoutType>

    @Insert fun insert(workoutType: WorkoutType)
}