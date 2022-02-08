package com.example.telegram.activity

import android.media.audiofx.Equalizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.telegram.R
import com.example.telegram.adapter.ChatAdapter
import com.example.telegram.adapter.CustomAdapter
import com.example.telegram.fragment.ChatFragment
import com.example.telegram.fragment.ContactsFragment
import com.example.telegram.fragment.SettingsFragment
import com.example.telegram.model.Chat
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList

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