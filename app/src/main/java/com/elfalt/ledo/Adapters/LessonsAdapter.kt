package com.elfalt.ledo.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.elfalt.ledo.R
import com.elfalt.ledo.pojo.Lesson
import com.elfalt.ledo.ui.JourneyLessonActivity
import kotlinx.android.synthetic.main.item_list_lessons.view.*

class LessonsAdapter(private val lessonList : List<Lesson>) : RecyclerView.Adapter<LessonsAdapter.LessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {

        val lessonView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_lessons,parent,false)
        return LessonViewHolder(
            lessonView
        )
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {

        holder.lessonName.text = lessonList[position].lessonName
        holder.lesson.text  = lessonList[position].lesson
        holder.details.text = lessonList[position].lessonDetails

        holder.start.setOnClickListener {
            val lessonVideo = Intent(it.context,JourneyLessonActivity::class.java)
            lessonVideo.putExtra("videoID",lessonList[position].videoID)
            ContextCompat.startActivity(it.context,lessonVideo,null)
        }
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    class LessonViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        val lessonName : TextView = itemView.item_name
        val lesson  : TextView = itemView.item_lesson
        val details : TextView = itemView.item_details
        val start   : Button = itemView.startButton
    }

}