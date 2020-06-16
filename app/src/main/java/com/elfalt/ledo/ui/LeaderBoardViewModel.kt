package com.elfalt.ledo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.LeaderboardUser

class LeaderBoardViewModel : ViewModel() {

    private val leaderBoardList : MutableLiveData<List<LeaderboardUser>> by lazy { MutableLiveData<List<LeaderboardUser>>() }

    fun getLeaderBoardData() : LiveData<List<LeaderboardUser>>{
        val leaderBoardUser : MutableList<LeaderboardUser> = mutableListOf()

        leaderBoardUser.add(
            LeaderboardUser(
                "Hannah Tran",
                "190,490 Points",
                R.drawable.hannah
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Louisa McGee",
                "128,480 Points",
                R.drawable.louisa
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Walter Osborne",
                "93,898 Points",
                R.drawable.walter
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Margaret Moreno",
                "80,389 Points",
                R.drawable.margaret
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Etta Silva",
                "64,123 Points",
                R.drawable.etta
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Sam Reynolds",
                "55,366 Points",
                R.drawable.sam
            )
        )

        leaderBoardUser.add(
            LeaderboardUser(
                "Jon Rashford",
                "45,455 Points",
                R.drawable.jon
            )
        )

        leaderBoardList.postValue(leaderBoardUser)

        return leaderBoardList
    }
}