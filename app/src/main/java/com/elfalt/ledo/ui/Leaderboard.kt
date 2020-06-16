package com.elfalt.ledo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.elfalt.ledo.Adapters.LeaderboardAdapter
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.LeaderboardUser
import kotlinx.android.synthetic.main.fragment_leaderboard.view.*

class Leaderboard : Fragment() {

    lateinit var leaderBoardViewModel : LeaderBoardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_leaderboard, container, false)

        v.recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        leaderBoardViewModel = ViewModelProvider(this).get(LeaderBoardViewModel::class.java)
        leaderBoardViewModel.getLeaderBoardData().observe(viewLifecycleOwner, Observer {

            v.recycler_view.adapter = LeaderboardAdapter(it)
        })

        return v

    }

    companion object {
        fun newInstance(): Leaderboard =
            Leaderboard()

    }


}


