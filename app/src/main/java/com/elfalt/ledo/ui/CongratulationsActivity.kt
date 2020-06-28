package com.elfalt.ledo.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_congratulation.*


class CongratulationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)
        val lesson = intent.getStringExtra("lesson")
        val courseName = intent.getStringExtra("courseName")

        val sharedPrefEdit = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()

        when(courseName) {
            "Self Awareness"    -> sharedPrefEdit.putString("lessonSelf", lesson)
            "Mind Mapping"      -> sharedPrefEdit.putString("lessonMind", lesson)
            "Personal Branding" -> sharedPrefEdit.putString("lessonPersonal", lesson)
        }

        if(courseName == "Self Awareness" && lesson == "Lesson 4"){
            sharedPrefEdit.putBoolean("mind_mapping_course", true)
        }else if(courseName == "Mind Mapping" && lesson == "Lesson 4"){
            sharedPrefEdit.putBoolean("personal_branding_course", true)
        }
         sharedPrefEdit.apply()

        next_button.setOnClickListener {

            if(lesson == "Lesson 4"){
                val intent = Intent(this, HomeScreenActivity:: class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, JourneyActivity::class.java)
                intent.putExtra("origin", lesson)
                intent.putExtra("courseName", courseName)
                startActivity(intent)
            }
        }


    }
}
