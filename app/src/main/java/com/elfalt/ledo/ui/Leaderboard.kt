package com.elfalt.ledo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elfalt.ledo.adapters.BadgeAdapter
import com.elfalt.ledo.adapters.LeaderboardAdapter
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.Badge
import com.elfalt.ledo.pojo.LeaderboardUser
import kotlinx.android.synthetic.main.fragment_leaderboard.view.*
import kotlinx.android.synthetic.main.fragment_leaderboard.view.badge

class Leaderboard : Fragment() {

    lateinit var leaderBoardViewModel : LeaderBoardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        lateinit var usersList: List<LeaderboardUser>
        lateinit var badgesList : List<Badge>

        v.recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        leaderBoardViewModel = ViewModelProvider(this).get(LeaderBoardViewModel::class.java)

        leaderBoardViewModel.getLeaderBoardData().observe(viewLifecycleOwner, Observer {
            usersList = it
            v.recycler_view.adapter = LeaderboardAdapter(usersList)

        })
        leaderBoardViewModel.getBadgesList().observe(viewLifecycleOwner, Observer {
            badgesList = it
        })

        v.leaderboard.setOnClickListener {
            v.leaderboard.setTextColor(ContextCompat.getColor(requireContext(),R.color.backgroundShape))
            v.badge.setTextColor(ContextCompat.getColor(requireContext(),R.color.textColorDisabled))
            v.recycler_view.adapter = LeaderboardAdapter(usersList)
        }
        v.badge.setOnClickListener {
            v.leaderboard.setTextColor(ContextCompat.getColor(requireContext(),R.color.textColorDisabled))
            v.badge.setTextColor(ContextCompat.getColor(requireContext(),R.color.backgroundShape))
            v.recycler_view.adapter = BadgeAdapter(badgesList)
        }

        return v

    }

    companion object {
        fun newInstance(): Leaderboard =
            Leaderboard()

    }

}


