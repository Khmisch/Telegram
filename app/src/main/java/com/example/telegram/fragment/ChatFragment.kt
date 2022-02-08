package com.example.telegram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.adapter.ChatAdapter
import com.example.telegram.model.Chat
import java.util.ArrayList

class ChatFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_chat, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 1))
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView!!.adapter = adapter

    }
    private fun getAllChats(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList<Chat>()
        for (i in 1..20) {
            if (i == 4|| i == 7|| i == 10) {
                chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", "Yes you are good at everything"))
            }else if (i == 8 || i == 9|| i == 13) {
                chats.add(Chat(R.drawable.im_sample_007, "Begzodbek Kurbanov", "What was the question?"))
            }else if (i == 2 || i == 11|| i == 15) {
                chats.add(Chat(R.drawable.im_sample_007, "Sherzodbek Kurbanov", "Has just sent you a voice message"))
            } else {
                chats.add(Chat(R.drawable.im_sample_007, "Khurshidbek Kurbanov", "Cute"))

            }
        }
        return chats
    }
}