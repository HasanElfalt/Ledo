package com.elfalt.ledo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_congratulation.*


class CongratulationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulation)
        val lesson = intent.getStringExtra("lesson_num")

        next_button.setOnClickListener {

            val intent = Intent(this, JourneyActivity:: class.java)
            intent.putExtra("origin",lesson)
            startActivity(intent)
        }


    }
}
