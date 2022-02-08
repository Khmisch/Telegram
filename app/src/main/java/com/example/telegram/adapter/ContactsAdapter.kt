package com.example.telegram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.fragment.ContactsFragment
import com.example.telegram.model.Chat
import com.google.android.material.imageview.ShapeableImageView

class ContactsAdapter(var fragment: ContactsFragment, var items: ArrayList<Chat>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacts_view, parent, false)
        return MessageViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]
        if (holder is MessageViewHolder){
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname
            val tv_message = holder.tv_message

            iv_profile.setImageResource(chat.profile)
            tv_fullname.text = chat.fullname
            tv_message.text = chat.message

        }
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile : ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)
        var tv_message : TextView = view.findViewById(R.id.tv_message)

    }


}