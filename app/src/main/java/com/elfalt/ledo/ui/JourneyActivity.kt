package com.elfalt.ledo.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elfalt.ledo.adapters.LessonsAdapter
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_journey.*

open class JourneyActivity : AppCompatActivity() {

    private lateinit var lessonLessonViewModel : LessonViewModel
    private lateinit var origin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)
        origin = intent.getStringExtra("origin")
        val courseName = intent.getStringExtra("courseName")

        course_name.text = courseName

        val sharedPref = getSharedPreferences("settings",Context.MODE_PRIVATE)
        val lessonNum = when(courseName) {
            "Self Awareness"    -> sharedPref.getString("lessonSelf", "Lesson 0")
            "Mind Mapping"      -> sharedPref.getString("lessonMind", "Lesson 0")
            else -> sharedPref.getString("lessonPersonal", "Lesson 0")
        }

        lessons_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        lessonLessonViewModel = ViewModelProvider(this).get(LessonViewModel::class.java)

        if(origin == "Home")    updateUI(lessonNum)
        else    updateUI(origin)

        lessonLessonViewModel.getLessonData(courseName).observe(this, Observer {

            lessons_recycler_view.adapter = LessonsAdapter(it,courseName)
        })

    }

    override fun onBackPressed() {
        if(origin == "Home")
            super.onBackPressed()
    }
    private fun updateUI(save :String?){

        when(save){
            "Lesson 1"-> {
                lessonLessonViewModel.lessonTwo = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                segmentedProgressBar.setCompletedSegments(1)
            }
            "Lesson 2"-> {lessonLessonViewModel.lessonTwo   = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                lessonLessonViewModel.lessonThree = true
                info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                strength_weakness.alpha = 1.0F
                segmentedProgressBar.setCompletedSegments(2)
            }
            "Lesson 3"-> {lessonLessonViewModel.lessonTwo   = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                lessonLessonViewModel.lessonThree = true
                info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                strength_weakness.alpha = 1.0F
                lessonLessonViewModel.lessonFour  = true
                info_goals.setImageResource(R.drawable.ic_book_shelf_lesson_finished)
                goals_aspiration.alpha = 1.0F
                segmentedProgressBar.setCompletedSegments(3)
            }
            "Lesson 4" ->{lessonLessonViewModel.lessonTwo   = true
                info_core.setImageResource(R.drawable.ic_book_shelf_lesson2)
                core_values.alpha = 1.0F
                lessonLessonViewModel.lessonThree = true
                info_strength.setImageResource(R.drawable.ic_book_shelf_lesson3)
                strength_weakness.alpha = 1.0F
                lessonLessonViewModel.lessonFour  = true
                info_goals.setImageResource(R.drawable.ic_book_shelf_lesson_finished)
                goals_aspiration.alpha = 1.0F
                segmentedProgressBar.setCompletedSegments(4)
            }
        }
    }
}
