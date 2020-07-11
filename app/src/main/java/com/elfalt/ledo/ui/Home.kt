package com.elfalt.ledo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {

    private val totalLessons = 12

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_home, container, false)

        var progressPercentage : Int

        val sharedPref = this.activity?.getSharedPreferences("settings", Context.MODE_PRIVATE)
        val mindMappingCourse  : Boolean = sharedPref!!.getBoolean("mind_mapping_course", false)
        val cardPersonalCourse : Boolean = sharedPref.getBoolean("personal_branding_course", false)

        val lessonSelf    = sharedPref.getString("lessonSelf", "Lesson 0")!!.filter { it.isDigit() }.toInt()
        val lessonMind     = sharedPref.getString("lessonMind", "Lesson 0")!!.filter { it.isDigit() }.toInt()
        val lessonPersonal = sharedPref.getString("lessonPersonal", "Lesson 0")!!.filter { it.isDigit() }.toInt()

        progressPercentage = (lessonSelf+lessonMind+lessonPersonal)*100/totalLessons
        v.progress_percentage.text = "$progressPercentage%"

        sharedPref.getString("lessonMind", "Lesson 0")
        sharedPref.getString("lessonPersonal", "Lesson 0")

        v.card_self.setOnClickListener {
            val intent = Intent (this.context, JourneyActivity:: class.java)
            intent.putExtra("origin","Home")
            intent.putExtra("courseName", "Self Awareness")
            startActivity(intent)
        }
        if(mindMappingCourse) {
            v.card_mind.setCardBackgroundColor(ContextCompat.getColor(requireContext(),android.R.color.white))
            v.card_mind.setOnClickListener {
                val intent = Intent(this.context, JourneyActivity::class.java)
                intent.putExtra("origin", "Home")
                intent.putExtra("courseName", "Mind Mapping")
                startActivity(intent)
            }
        }
        if (cardPersonalCourse) {
            v.card_personal.setCardBackgroundColor(ContextCompat.getColor(requireContext(),android.R.color.white))
            v.card_personal.setOnClickListener {
                val intent = Intent(this.context, JourneyActivity::class.java)
                intent.putExtra("origin", "Home")
                intent.putExtra("courseName", "Personal Branding")
                startActivity(intent)
            }
        }

    return v
    }

    companion object {

        fun newInstance() : Home =
            Home()
    }
}
