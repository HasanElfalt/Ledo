package com.elfalt.ledo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elfalt.ledo.R



class HomeScrolled : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.fragment_home_scrolled, container, false)

        return v
    }
    companion object {
        fun newInstance(): HomeScrolled =
            HomeScrolled()
    }
}
