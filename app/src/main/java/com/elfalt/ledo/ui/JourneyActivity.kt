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
        origin = intent.getStringExtra("origin")

        lessons_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        lessonLessonViewModel = ViewModelProvider(this).get(LessonViewModel::class.java)

        when(origin){
            "Lesson 1"-> {
                lessonLessonViewModel.lessonTwo = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                }
            "Lesson 2"-> {lessonLessonViewModel.lessonTwo   = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                lessonLessonViewModel.lessonThree = true
                info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                strength_weakness.alpha = 1.0F}
            "Lesson 3"-> {lessonLessonViewModel.lessonTwo   = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                lessonLessonViewModel.lessonThree = true
                info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                strength_weakness.alpha = 1.0F
                lessonLessonViewModel.lessonFour  = true
                info_goals.setImageResource(R.drawable.ic_book_shelf_lesson_finished)
                goals_aspiration.alpha = 1.0F}
            "Lesson 4" ->{lessonLessonViewModel.lessonTwo   = true
                    info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                    core_values.alpha = 1.0F
                    lessonLessonViewModel.lessonThree = true
                    info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                    strength_weakness.alpha = 1.0F
                    lessonLessonViewModel.lessonFour  = true
                    info_goals.setImageResource(R.drawable.ic_book_shelf_lesson_finished)
                    goals_aspiration.alpha = 1.0F }
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
