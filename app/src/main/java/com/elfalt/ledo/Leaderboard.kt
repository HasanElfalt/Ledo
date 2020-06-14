package com.elfalt.ledo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class Leaderboard : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        val usersList: List<LeaderboardUser> = getUsersList()
        recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = LeaderboardAdapter(usersList as ArrayList<LeaderboardUser>)
        return v




    }






    companion object {
        fun newInstance(): Leaderboard = Leaderboard()

    }
    private fun getUsersList() : List<LeaderboardUser>{

        val leaderboardUser : MutableList<LeaderboardUser> = mutableListOf()

        leaderboardUser.add(LeaderboardUser("Hannah Tran","190,490 Points",R.drawable.hannah))

        leaderboardUser.add(LeaderboardUser("Louisa McGee", "128,480 Points",R.drawable.louisa))

        leaderboardUser.add(LeaderboardUser("Walter Osborne","93,898 Points",R.drawable.walter))

        leaderboardUser.add(LeaderboardUser("Margaret Moreno","80,389 Points",R.drawable.margaret))

        leaderboardUser.add(LeaderboardUser("Etta Silva","64,123 Points",R.drawable.etta))

        leaderboardUser.add(LeaderboardUser("Sam Reynolds","55,366 Points",R.drawable.sam))

        leaderboardUser.add(LeaderboardUser("Jon Rashford","45,455 Points",R.drawable.jon))


        return leaderboardUser
    }





}


