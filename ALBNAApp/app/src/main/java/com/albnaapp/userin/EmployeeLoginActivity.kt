package com.albnaapp.userin

import com.albnaapp.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.albnaapp.LoginActivity
import com.albnaapp.databinding.ActivityEmployeeLoginBinding

class EmployeeLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityEmployeeLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_employee_login)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, EmployeesUiActivity::class.java)
            startActivity(intent)
        }
        binding.btnTxtBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}