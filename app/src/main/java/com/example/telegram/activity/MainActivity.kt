package com.example.telegram.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.telegram.R
import com.example.telegram.fragment.ChatFragment
import com.example.telegram.fragment.ContactsFragment
import com.example.telegram.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactsFragment=ContactsFragment()
        val chatFragment=ChatFragment()
        val settingsFragment=SettingsFragment()
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        setCurrentFragment(contactsFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_contacts->setCurrentFragment(contactsFragment)
                R.id.menu_chats->setCurrentFragment(chatFragment)
                R.id.menu_settings->setCurrentFragment(settingsFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}