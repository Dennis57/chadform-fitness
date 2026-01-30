package com.example.chadformfitness.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutSet(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "workout_type_id") val workoutTypeId: String,
    @ColumnInfo(name = "reps") val reps: Int,
    @ColumnInfo(name = "sets") val sets: Int,
    @ColumnInfo(name = "time") val time: Int

)
