package com.example.chadformfitness.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.chadformfitness.database.entity.WorkoutSession

@Dao
interface WorkoutSessionDao {
    @Query("SELECT * FROM workoutsession")
    fun getAll(): List<WorkoutSession>

    @Insert fun insert(workoutSession: WorkoutSession)

}