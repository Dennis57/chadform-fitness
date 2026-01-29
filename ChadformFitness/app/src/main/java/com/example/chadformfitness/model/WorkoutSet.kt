package com.example.chadformfitness.model

data class WorkoutSet(
    val id: String,
    val workoutTypeId: String,
    val reps: Int,
    val sets: Int,
    val time: Int

)
