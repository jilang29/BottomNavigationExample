package com.example.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationexample.fragment.HomeFragment
import com.example.bottomnavigationexample.fragment.NotificationFragment
import com.example.bottomnavigationexample.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homefragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment (homefragment)
        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homefragment)
                R.id.menu_notifications -> makeCurrentFragment(notificationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}