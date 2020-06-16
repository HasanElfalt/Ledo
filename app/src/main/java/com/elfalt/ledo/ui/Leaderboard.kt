package com.elfalt.ledo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.elfalt.ledo.Adapters.BadgeAdapter
import com.elfalt.ledo.Adapters.LeaderboardAdapter
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.LeaderboardUser
import kotlinx.android.synthetic.main.badge_item.*
import kotlinx.android.synthetic.main.fragment_leaderboard.view.*
import kotlinx.android.synthetic.main.fragment_leaderboard.view.badge

class Leaderboard : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        val usersList: List<LeaderboardUser> = getUsersList()
        val badgesList : List<Badge> = getBadgesList()

        v.recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        v.recycler_view.adapter =
            LeaderboardAdapter(usersList)

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

    private fun getBadgesList(): List<Badge> {

        val badges : MutableList<Badge> = mutableListOf()

       badges.add(
            Badge(
                "Badge 1",
                "100,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 2",
                "200,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 3",
                "300,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 4",
                "400,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 5",
                "500,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 6",
                "600,000 Points",
                R.drawable.ic_quick_learner
            )
        )

        badges.add(
            Badge(
                "Badge 7",
                "700,000 Points",
                R.drawable.ic_quick_learner
            )
        )


        return badges
    }


    companion object {
        fun newInstance(): Leaderboard =
            Leaderboard()

    }

    private fun getUsersList() : List<LeaderboardUser>{

        val leaderboardUser : MutableList<LeaderboardUser> = mutableListOf()

        leaderboardUser.add(
            LeaderboardUser(
                "Hannah Tran",
                "190,490 Points",
                R.drawable.hannah
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Louisa McGee",
                "128,480 Points",
                R.drawable.louisa
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Walter Osborne",
                "93,898 Points",
                R.drawable.walter
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Margaret Moreno",
                "80,389 Points",
                R.drawable.margaret
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Etta Silva",
                "64,123 Points",
                R.drawable.etta
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Sam Reynolds",
                "55,366 Points",
                R.drawable.sam
            )
        )

        leaderboardUser.add(
            LeaderboardUser(
                "Jon Rashford",
                "45,455 Points",
                R.drawable.jon
            )
        )


        return leaderboardUser
    }




}


