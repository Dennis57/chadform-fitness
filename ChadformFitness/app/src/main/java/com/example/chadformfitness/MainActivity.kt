package com.example.chadformfitness

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chadformfitness.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Need to implement this if using data binding or viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_main)

        val recyclerView = binding.rvWorkoutSessionList

        val numberOfColumns = 2

        recyclerView.layoutManager =
            GridLayoutManager(this, numberOfColumns)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cl_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}