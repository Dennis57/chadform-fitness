package com.example.chadformfitness.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chadformfitness.R
import com.example.chadformfitness.adapter.WorkoutPlanAdapter
import com.example.chadformfitness.databinding.ActivityWorkoutPlanBinding

class WorkoutPlanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workout_plan)

        binding = ActivityWorkoutPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        val dataset = arrayOf("Plan 1", "Plan 2", "Plan 3", "Plan 4")

        binding.rvWorkoutPlan.layoutManager = LinearLayoutManager(this)
        binding.rvWorkoutPlan.adapter = WorkoutPlanAdapter(dataset)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cl_workout_plan_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}