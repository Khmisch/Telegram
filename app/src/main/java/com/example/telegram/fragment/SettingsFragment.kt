package com.example.telegram.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.telegram.R
import com.example.telegram.activity.AppearanceActivity
import com.example.telegram.activity.NotificaionActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener


class SettingsFragment : Fragment() {
    lateinit var tv_notification: TextView
    lateinit var imageView: ImageView
    lateinit var tv_appearance: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        initViews(view)
        return view
    }

    private enum class State {
        EXPANDED, COLLAPSED, IDLE
    }
    private fun initViews(view: View) {
        val TAG = "AppBarTest"
        val mAppBarLayout: AppBarLayout = view.findViewById(R.id.appbar)
        mAppBarLayout.addOnOffsetChangedListener(object : OnOffsetChangedListener {
            private var state: State? = null
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                imageView = view.findViewById(R.id.ic_search)
                state = if (verticalOffset == 0) {
                    if (state !== State.EXPANDED) {
                        Log.d(TAG, "Expanded")
                        imageView.visibility = View.INVISIBLE
                    }
                    State.EXPANDED
                } else if (Math.abs(verticalOffset) >= appBarLayout.totalScrollRange) {
                    if (state !== State.COLLAPSED) {
                        Log.d(TAG, "Collapsed")
                        imageView.visibility = View.VISIBLE
                    }
                    State.COLLAPSED
                } else {
                    if (state !== State.IDLE) {
                        Log.d(TAG, "Idle")
                    }
                    State.IDLE
                }
            }
        })
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