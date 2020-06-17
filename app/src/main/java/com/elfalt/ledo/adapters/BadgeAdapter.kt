package com.elfalt.ledo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.Badge
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.badge_item.view.*

class BadgeAdapter (val badgeList: List<Badge>) :
    RecyclerView.Adapter<BadgeAdapter.BadgeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val badgeView = LayoutInflater.from(parent.context).inflate(R.layout.badge_item,parent,false)

        return BadgeViewHolder(badgeView)
    }

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) {

        holder.name.text  = badgeList[position].Name
        holder.point.text = badgeList[position].Point
        holder.image.setImageResource(badgeList[position].Image)

    }
    override fun getItemCount(): Int {
        return badgeList.size
    }


    class BadgeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name  : TextView = itemView.badge_name
        val point : TextView = itemView.badge_point
        val image : CircleImageView = itemView.badge
    }
}