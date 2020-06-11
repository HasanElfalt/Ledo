package com.elfalt.ledo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_journey.*

class JourneyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)

        val lessonList = getLessonData()
        lessons_recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        lessons_recycler_view.adapter = LessonsAdapter(lessonList)
    }

    private fun getLessonData() : List<Lesson>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1","Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas"))

        lessons.add(
            Lesson("Support Systems", "Lesson 2","Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas"))

        lessons.add(
            Lesson("Support Systems", "Lesson 3","Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas"))

        lessons.add(
            Lesson("Support Systems", "Lesson 4","Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas"))


        return lessons
    }
}
