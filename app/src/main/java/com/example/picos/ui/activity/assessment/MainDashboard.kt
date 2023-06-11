package com.example.picos.ui.activity.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.picos.R
import com.example.picos.databinding.DashboardMainBinding

class MainDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //INI JUGA GA MAU DIIMPORT :(
        val binding: DashboardMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_dashboard)

    }
}

