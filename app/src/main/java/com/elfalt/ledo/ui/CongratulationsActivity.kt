package com.elfalt.ledo.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_congratulation.*


class CongratulationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)
        val lesson = intent.getStringExtra("lesson")

        val sharedPrefEdit = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        sharedPrefEdit.putString("lessonNum",lesson)
        sharedPrefEdit.apply()

        next_button.setOnClickListener {
            val intent : Intent
            if(lesson == "Lesson 4"){
                intent = Intent(this, HomeScreenActivity:: class.java)
                val sharedPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
                val mindMappingCourse = sharedPref.edit().putBoolean("mind_mapping_course", true)
                //val cardPersonalCourse = sharedPref.putBoolean("personal_branding_course", true)

            }else {
                intent = Intent(this, JourneyActivity::class.java)
                intent.putExtra("origin", lesson)
            }
            startActivity(intent)
        }


    }
}
