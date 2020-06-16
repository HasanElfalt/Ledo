package com.elfalt.ledo.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.fragment_home_scrolled.view.*


class Home : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_home, container, false)

        v.card_self.setOnClickListener {
            val intent = Intent (this.context, JourneyActivity:: class.java)
            startActivity(intent)
        }
    return v
    }

    companion object {

        fun newInstance() : Home =
            Home()
    }
}
