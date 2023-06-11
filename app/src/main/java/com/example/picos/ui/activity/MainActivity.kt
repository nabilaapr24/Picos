package com.example.picos.ui.activity

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.picos.databinding.ActivityMainDashboardBinding
import com.example.picos.ui.fragment.HomeFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.picos.R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


        val fragment = HomeFragment()
        fragmentTransaction.replace(com.example.picos.R.id.fragment_container_view_tag, fragment)
        fragmentTransaction.commit()

    }

}