package com.example.picos.ui.activity

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.picos.databinding.ActivityMainBinding
import com.example.picos.databinding.ActivityMainDashboardBinding
import com.example.picos.ui.activity.assessment.MainDashboard
import com.example.picos.ui.fragment.CalendarFragment
import com.example.picos.ui.fragment.HistoryFragment
import com.example.picos.ui.fragment.HomeFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.picos.R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


        val fragment = HomeFragment()
        fragmentTransaction.replace(binding.fragmentContainerViewTag.id, fragment)
        fragmentTransaction.commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            val fragmentManager: FragmentManager = supportFragmentManager

            when (menuItem.itemId) {
                com.example.picos.R.id.navigation_home -> {
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(binding.fragmentContainerViewTag.id, HomeFragment())
                    fragmentTransaction.commit()
                    true
                }
                com.example.picos.R.id.navigation_calendar -> {
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(binding.fragmentContainerViewTag.id, CalendarFragment())
                    fragmentTransaction.commit()
                    true
                }
                com.example.picos.R.id.navigation_logs -> {
                    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(binding.fragmentContainerViewTag.id, HistoryFragment())
                    fragmentTransaction.commit()
                    true
                }
                else -> false
            }
        }




    }

}