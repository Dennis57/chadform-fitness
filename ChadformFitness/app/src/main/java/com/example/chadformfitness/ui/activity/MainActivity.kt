package com.example.chadformfitness.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.chadformfitness.R
import com.example.chadformfitness.databinding.ActivityMainBinding
import com.example.chadformfitness.ui.fragment.AccountFragment
import com.example.chadformfitness.ui.fragment.CalendarFragment
import com.example.chadformfitness.ui.fragment.HomeFragment
import com.example.chadformfitness.ui.fragment.WellnessFragment

class MainActivity : AppCompatActivity() {

    // Need to implement this if using data binding or viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Learn best practice of switching between fragments

        // Create fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                replace<HomeFragment>(R.id.fcv_main)
            }
        }

        binding.tvHome.setOnClickListener {
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                replace<HomeFragment>(R.id.fcv_main)
            }
        }

        binding.tvCalendar.setOnClickListener {
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                replace<CalendarFragment>(R.id.fcv_main)
            }
        }

        binding.tvWellness.setOnClickListener {
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                replace<WellnessFragment>(R.id.fcv_main)
            }
        }

        binding.tvAccount.setOnClickListener {
            supportFragmentManager.commit {
                setCustomAnimations(
                    R.anim.slide_in, // enter
                    R.anim.fade_out, // exit
                    R.anim.fade_in, // popEnter
                    R.anim.slide_out // popExit
                )
                setReorderingAllowed(true)
                replace<AccountFragment>(R.id.fcv_main)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cl_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}