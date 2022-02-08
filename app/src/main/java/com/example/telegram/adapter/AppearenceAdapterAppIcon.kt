package com.example.telegram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.model.Chat
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class AppearenceAdapterAppIcon (var fragment: Context, var items: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_appearance_view_app_icon, parent, false)
        return AddedViewHolderYes(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is AddedViewHolderYes){
            val iv_profile = holder.iv_profile

            iv_profile.setImageResource(chat.profile)
        }

        }

    class AddedViewHolderYes(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)


    }

}