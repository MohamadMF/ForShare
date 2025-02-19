package com.albnaapp.userin

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import com.albnaapp.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.albnaapp.SettingsActivity
import com.albnaapp.databinding.ActivityEmployeesUiBinding
import java.util.*


class EmployeesUiActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityEmployeesUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_employees_ui)

        navHostFragment = supportFragmentManager.findFragmentById(binding.navHostEmpUi.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration= AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.fragmentHomeEmpsUi, R.id.warehouseList, R.id.officeList, R.id.importList),
            binding.drawerLayout,
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.appBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        val headerElements = binding.drawerPane.getHeaderView(0)
        val editProfile = headerElements.findViewById<TextView>(R.id.edit_profile)
        val exitApp = headerElements.findViewById<TextView>(R.id.exit)
        editProfile.setOnClickListener {
            Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show()
        }
        exitApp.setOnClickListener {
            finish()
        }

        binding.drawerPane.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            when(menuItem.itemId) {
                // In Header Layout
                R.id.call_ceo -> {
                    Toast.makeText(this, "Call CEO Page Not Created yet", Toast.LENGTH_SHORT).show()
                }
                R.id.chat_ceo -> {
                    Toast.makeText(this, "Chat CEO Page Not Created yet", Toast.LENGTH_SHORT).show()
                }

                // In Menu Layout
                R.id.chats -> {
                    Toast.makeText(this, "Chats Page Not Created yet", Toast.LENGTH_SHORT).show()
                }
                R.id.create_note -> {
                    Toast.makeText(this, "Create Note Page Not Created yet", Toast.LENGTH_SHORT).show()
                }
                R.id.add_reminder -> {
                    Toast.makeText(this, "Add Reminder Page Not Created yet", Toast.LENGTH_SHORT).show()
                }

                R.id.app_settings -> {
                    navController.navigate(R.id.app_settings)
                }
                R.id.app_feedback -> {
                    navController.navigate(R.id.app_feedback)
                }
                R.id.app_about -> {
                    navController.navigate(R.id.app_about)
                }
            }
            menuItem.isChecked = true
            binding.drawerLayout.close()
            true
        }

        binding.appBar.setupWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id != R.id.fragmentHomeEmpsUi && destination.id != R.id.warehouseList && destination.id != R.id.officeList && destination.id != R.id.importList) {
                binding.bottomNavigationView.visibility = View.GONE
            } else {
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

    }

    override fun onNavigateUp(): Boolean {
        navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostEmpUi.id) as NavHostFragment
        navController = navHostFragment.navController
        return navController.navigateUp(appBarConfiguration) || super.onNavigateUp()
    }
}