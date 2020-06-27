package com.elfalt.ledo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class Home : Fragment() {

    var mindMappingCourse  : Boolean = true
    var cardPersonalCourse : Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_home, container, false)

        v.card_self.setOnClickListener {
            val intent = Intent (this.context, JourneyActivity:: class.java)
            intent.putExtra("origin","Home")
            intent.putExtra("courseName", "Self Awareness")
            startActivity(intent)
        }
        if(mindMappingCourse) {
            v.card_mind.alpha = 1.0F
            v.card_mind.setOnClickListener {
                val intent = Intent(this.context, JourneyActivity::class.java)
                intent.putExtra("origin", "Home")
                intent.putExtra("courseName", "Mind Mapping")
                startActivity(intent)
            }
        }
        if (cardPersonalCourse) {
            v.card_personal.alpha = 1.0F
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
