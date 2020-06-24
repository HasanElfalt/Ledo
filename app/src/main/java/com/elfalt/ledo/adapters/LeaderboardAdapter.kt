package com.elfalt.ledo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.LeaderboardUser
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.leaderboard_item.view.*

class LeaderboardAdapter (val userList:List<LeaderboardUser>):RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val leaderboardView = LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item,parent,false)
        return ViewHolder(
            leaderboardView
        )
    }

    override fun getItemCount(): Int {
     return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = userList[position].Name
        holder.point.text=userList[position].Point
        holder.image.setImageResource(userList[position].Image)
        holder.id.text = userList[position].Id
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.name_profile
        val point :TextView = itemView.point
        val image: CircleImageView = itemView.profile_picture
        val id : TextView = itemView.user_id

    }
}