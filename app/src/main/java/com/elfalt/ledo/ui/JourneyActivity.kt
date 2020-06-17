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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)

        lessons_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        lessonLessonViewModel = ViewModelProvider(this).get(LessonViewModel::class.java)
        lessonLessonViewModel.getLessonData().observe(this, Observer {

            lessons_recycler_view.adapter = LessonsAdapter(it)
        })

    }

}
