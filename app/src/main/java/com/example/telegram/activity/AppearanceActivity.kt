package com.example.telegram.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.adapter.AppearenceAdapter
import com.example.telegram.adapter.AppearenceAdapterAppIcon
import com.example.telegram.fragment.SettingsFragment
import com.example.telegram.model.Chat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener


class AppearanceActivity : AppCompatActivity() {

    lateinit var nestedScrollView: NestedScrollView
    lateinit var recyclerView: RecyclerView
    lateinit var imageView: ImageView

    lateinit var recyclerView_app: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appearance)
        initViews()
        imageView = findViewById(R.id.iv_back)
        imageView.setOnClickListener {
        }
    }

    private fun initViews() {

        nestedScrollView = findViewById(R.id.nestedScrollView)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView_app = findViewById(R.id.recyclerView_app)
        val horizontalLayoutManagaer = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManagaer
        refreshAdapter(getAllIcon())
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_app.layoutManager = horizontalLayoutManager
        refreshAdapterApp(getAllChats())
    }

    private fun refreshAdapterApp(chats: ArrayList<Chat>) {
        recyclerView.isNestedScrollingEnabled = false
        val adapter = AppearenceAdapter(this, chats)
        recyclerView!!.adapter = adapter
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter_app = AppearenceAdapterAppIcon(this, chats)
        recyclerView_app!!.adapter = adapter_app

    }

    private fun getAllChats(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList<Chat>()
        for (i in 1..6) {
            if (i == 1) {
                chats.add(Chat(R.drawable.ic_theme, "", "", true))
            } else if (i == 2) {
                chats.add(Chat(R.drawable.ic_theme2, "", "", false))
            } else if (i == 3) {
                chats.add(Chat(R.drawable.ic_theme3, "", "", false))
            } else if (i == 4) {
                chats.add(Chat(R.drawable.ic_theme4, "", "", false))
            } else if (i == 5) {
                chats.add(Chat(R.drawable.ic_theme5, "", "", false))
            } else {
                chats.add(Chat(R.drawable.ic_theme6, "", "", false))
            }
        }
        return chats
    }

    private fun getAllIcon(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList<Chat>()
        for (i in 1..5) {
            chats.add(Chat(R.drawable.ic_telegram, "", "", false))
        }
        return chats
    }

}