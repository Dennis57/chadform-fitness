package com.example.chadformfitness.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.chadformfitness.database.entity.WorkoutSet

@Dao
interface WorkoutSetDao {
    @Query("SELECT * FROM workoutset")
    fun getAll(): List<WorkoutSet>
}