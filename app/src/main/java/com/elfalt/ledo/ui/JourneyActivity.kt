package com.elfalt.ledo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elfalt.ledo.adapters.LessonsAdapter
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_journey.*

class JourneyActivity : AppCompatActivity() {

    lateinit var lessonLessonViewModel : LessonViewModel
    lateinit var origin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)
        origin = intent!!.getStringExtra("origin")

        lessons_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        lessonLessonViewModel = ViewModelProvider(this).get(LessonViewModel::class.java)

        when(origin){
            "Lesson 1"-> lessonLessonViewModel.lessonTwo   = true
            "Lesson 2"-> lessonLessonViewModel.lessonThree = true
            "Lesson 3"-> lessonLessonViewModel.lessonFour  = true
        }

        lessonLessonViewModel.getLessonData().observe(this, Observer {

            lessons_recycler_view.adapter = LessonsAdapter(it)
        })

    }

    override fun onBackPressed() {
        if(origin == "Home")
            super.onBackPressed()
    }
}
