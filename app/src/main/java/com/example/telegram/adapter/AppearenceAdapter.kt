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

class AppearenceAdapter (var fragment: Context, var items: ArrayList<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Chat = items[position]
        return if (!chat.first) {
            TYPE_ADDED_NO
        }
        else TYPE_ADDED_YES
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        if (viewType == TYPE_ADDED_YES) {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_appearance_view, parent, false)
            return AddedViewHolderYes(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_appearance_view_2, parent, false)
        return AddedViewHolderNo(view)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is AddedViewHolderYes){
            val iv_profile = holder.iv_profile

            iv_profile.setImageResource(chat.profile)
        }
        else  if (holder is AddedViewHolderNo){
            val iv_profile = holder.iv_profile


            iv_profile.setImageResource(chat.profile)

        }

    }

    class AddedViewHolderYes(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)


    }
    class AddedViewHolderNo(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)

    }

}