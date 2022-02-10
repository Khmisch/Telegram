package com.example.telegram.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.telegram.R
import com.example.telegram.fragment.SettingsFragment


class NotificaionActivity : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaion)

        linearLayout = findViewById(R.id.linearLayout)
        linearLayout.setOnClickListener {

            finish()
        }
    }

}