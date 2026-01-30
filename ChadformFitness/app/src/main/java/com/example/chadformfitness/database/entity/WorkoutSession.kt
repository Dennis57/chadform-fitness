package com.example.chadformfitness.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutSession(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "session_name") val sessionName: String,
    @ColumnInfo(name = "session_color") val sessionColor: String
)