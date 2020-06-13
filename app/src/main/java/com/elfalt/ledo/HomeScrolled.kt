package com.elfalt.ledo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class HomeScrolled : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home_scrolled, container, false)
    companion object {
        fun newInstance(): HomeScrolled = HomeScrolled()
    }
}
