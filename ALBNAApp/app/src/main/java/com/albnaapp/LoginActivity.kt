package com.albnaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.databinding.DataBindingUtil
import com.albnaapp.databinding.ActivityLoginBinding
import com.albnaapp.userin.EmployeeLoginActivity
import java.util.*
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )

        binding.btnSetArabic.setOnClickListener {
            setLocale("ar")
        }

        binding.btnSetEnglish.setOnClickListener {
            setLocale("en")
        }

        binding.btnEmployee.setOnClickListener {
            val intent = Intent(this, EmployeeLoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnTxtExit.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun setLocale(lang: String) {
        val language = Locale(lang)
        val res: Resources = resources
        val dm: DisplayMetrics = res.displayMetrics
        val conf: Configuration = res.configuration
        conf.locale = language
        res.updateConfiguration(conf, dm)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            res.configuration.setLayoutDirection(language)
            (if (lang == "ar") {
                View.LAYOUT_DIRECTION_RTL
            } else {
                View.LAYOUT_DIRECTION_LTR
            }).also { window.decorView.layoutDirection = it }
        }
        val refresh = Intent(this, LoginActivity::class.java)
        startActivity(refresh)
        finish()
    }
}