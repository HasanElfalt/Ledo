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
        var lesson = intent.getStringExtra("lesson")
        val courseName = intent.getStringExtra("courseName")

        val sharedPrefEdit = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()

        when(courseName) {
            "Self Awareness"    -> {
                val temp = getSharedPreferences("settings",Context.MODE_PRIVATE).getString("lessonSelf",lesson)!!
                if(lesson >= temp)
                    sharedPrefEdit.putString("lessonSelf", lesson)
                else
                    lesson = temp

            }
            "Mind Mapping"      -> {
                val temp = getSharedPreferences("settings",Context.MODE_PRIVATE).getString("lessonMind",lesson)!!
                if(lesson >= temp)
                    sharedPrefEdit.putString("lessonMind", lesson)
                else
                    lesson = temp

            }
            "Personal Branding" -> {
                val temp = getSharedPreferences("settings",Context.MODE_PRIVATE).getString("lessonPersonal",lesson)!!
                if(lesson >= temp)
                    sharedPrefEdit.putString("lessonPersonal", lesson)
                else
                    lesson = temp
            }
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
