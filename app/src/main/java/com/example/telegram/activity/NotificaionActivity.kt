package com.example.telegram.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.telegram.R
import com.example.telegram.fragment.SettingsFragment


class NotificaionActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaion)

//        imageView = findViewById(R.id.iv_back)
//        imageView.setOnClickListener {
//        }
    }

}