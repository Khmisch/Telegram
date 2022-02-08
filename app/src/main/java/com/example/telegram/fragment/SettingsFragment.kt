package com.example.telegram.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram.R
import com.example.telegram.activity.AppearanceActivity
import com.example.telegram.activity.NotificaionActivity

class SettingsFragment : Fragment() {
    lateinit var tv_notification: TextView
    lateinit var tv_appearance: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tv_notification = view.findViewById(R.id.tv_notification)
        tv_appearance = view.findViewById(R.id.tv_appearance)

        tv_notification.setOnClickListener {
            callNotificaionActivity()
        }
           tv_appearance.setOnClickListener {
            callAppearanceActivity()
        }

    }

    private fun callNotificaionActivity() {
        val intent = Intent (getActivity(), NotificaionActivity::class.java)
        getActivity()?.startActivity(intent)
    }
    private fun callAppearanceActivity() {
        val intent = Intent (getActivity(), AppearanceActivity::class.java)
        getActivity()?.startActivity(intent)
    }

}