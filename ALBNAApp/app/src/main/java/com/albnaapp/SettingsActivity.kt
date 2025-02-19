package com.albnaapp

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.albnaapp.databinding.ActivitySettingsBinding
import com.albnaapp.userin.EmployeesUiActivity
import java.util.*


class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appTheme.setOnClickListener {
            showThemeDialog()
        }

        binding.appLanguage.setOnClickListener {
            showLanguageDialog()
        }
        setSupportActionBar(binding.settingActionBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    private fun showThemeDialog() {
        // setup the alert builder

        val choosing = resources.getString(R.string.str_choose_theme)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(choosing)

        // add a radio button list
        val titleName = resources.getStringArray(R.array.themes)
        val checkedItem = 0 // cow
        builder.setSingleChoiceItems(titleName, checkedItem) { _, which ->
            // user checked an item
            when (which) {
                0 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }

    private fun setLocale(lang: String) {
        val language = Locale(lang)
        val res: Resources = resources
        val dm: DisplayMetrics = res.displayMetrics
        val conf: Configuration = res.configuration
        conf.locale = language
        res.updateConfiguration(conf, dm)
        res.configuration.setLayoutDirection(language)
        (if (lang == "ar") {
            View.LAYOUT_DIRECTION_RTL
        } else {
            View.LAYOUT_DIRECTION_LTR
        }).also { window.decorView.layoutDirection = it }
        val refresh = Intent(this, EmployeesUiActivity::class.java)
        startActivity(refresh)
        finish()
    }

    private fun showLanguageDialog() {
        // setup the alert builder

        val choosing = resources.getString(R.string.str_chosAppLang)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(choosing)

        // add a radio button list
        val titleName = arrayOf(resources.getString(R.string.btnStr_arabic),
            resources.getString(R.string.btnStr_english))
        val checkedItem = 0 // cow
        builder.setSingleChoiceItems(titleName, checkedItem) { _, which ->
            // user checked an item
            when (which) {
                0 -> setLocale("ar")
                1 -> setLocale("en")
            }
        }

        /* add OK and Cancel buttons
        val ok = resources.getString(R.string.str_ok)
        builder.setPositiveButton(ok) { dialog, which ->
            // user clicked OK
        }
        val cancel = resources.getString(R.string.str_cancel)
        builder.setNegativeButton(cancel, null)
        */

        // create and show the alert dialog
        val dialog = builder.create()
        dialog.show()
    }
}