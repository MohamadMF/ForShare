package com.example.appfortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.appfortest.adapter.CardAdapter
import com.example.appfortest.data.DeptsDatasource
import com.example.appfortest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val officeSections = DeptsDatasource().loadOfficeSections()
        binding.rcyclrOfficeDep.adapter = CardAdapter(this,officeSections)
        binding.rcyclrOfficeDep.setHasFixedSize(true)
    }
}