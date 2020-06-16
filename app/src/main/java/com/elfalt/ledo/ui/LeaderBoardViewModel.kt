package com.elfalt.ledo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.LeaderboardUser

class LeaderBoardViewModel : ViewModel() {

    private val leaderBoardList : MutableLiveData<List<LeaderboardUser>> by lazy { MutableLiveData<List<LeaderboardUser>>() }
    private val badgesLiveData : MutableLiveData<List<Badge>> by lazy { MutableLiveData<List<Badge>>() }

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

    fun getBadgesList(): LiveData<List<Badge>> {

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

        badgesLiveData.postValue(badges)
        return badgesLiveData
    }
}