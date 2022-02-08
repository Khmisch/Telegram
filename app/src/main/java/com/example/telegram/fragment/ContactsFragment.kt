package com.example.telegram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.adapter.ContactsAdapter
import com.example.telegram.model.Chat
import java.util.ArrayList

class ContactsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_contacts, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 1))
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ContactsAdapter(this, chats)
        recyclerView!!.adapter = adapter

    }
    private fun getAllChats(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList<Chat>()
        for (i in 1..20) {
            if (i == 4|| i == 7|| i == 10) {
                chats.add(Chat(R.drawable.im_sample_007, "Mukaddam", "last seen a long time ago"))
            }else if (i == 8 || i == 9|| i == 13) {
                chats.add(Chat(R.drawable.im_sample_007, "Begzodbek Kurbanov", "last seen within a week"))
            }else if (i == 2 || i == 11|| i == 15) {
                chats.add(Chat(R.drawable.im_sample_007, "Marifat", "last seen within a month"))
            } else {
                chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", "last seen recently"))

            }
        }
        return chats
    }
}