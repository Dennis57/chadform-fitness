package com.example.chadformfitness.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutType(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "session_id") val sessionId: String,
    @ColumnInfo(name = "workout_name") val workoutName: String
)
