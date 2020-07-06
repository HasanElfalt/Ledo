package com.elfalt.ledo.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.questions_group_dialog.view.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var lesson : String
    private lateinit var courseName :String
    private lateinit var VIDEO_ID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        lesson = intent.getStringExtra("lesson")
        courseName = intent.getStringExtra("courseName")
        VIDEO_ID  = intent.getStringExtra("videoID")

        lesson_quiz_num.text = "$lesson Quiz"

        updateUI(lesson)

        submitbtn.setOnClickListener{

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.questions_group_dialog,null)

            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()

            mDialogView.agree_btn.setOnClickListener {
                val intent = Intent(this, CongratulationsActivity:: class.java)
                intent.putExtra("lesson",lesson)
                intent.putExtra("courseName", courseName)
                startActivity(intent)

            }
            mDialogView.cancel_btn.setOnClickListener {
                mAlertDialog.dismiss()

            }
        }
        card_view_answer1.setOnClickListener(this)
        card_view_answer2.setOnClickListener(this)
        card_view_answer3.setOnClickListener(this)
        card_view_answer4.setOnClickListener(this)
    }

    override fun onBackPressed() {
        val intent = Intent(this, JourneyLessonActivity:: class.java)
        intent.putExtra("lesson",lesson)
        intent.putExtra("courseName", courseName)
        intent.putExtra("videoID",VIDEO_ID)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.card_view_answer1 -> {
                submitbtn.isEnabled = true
                submitbtn.setBackgroundResource(R.drawable.background_button)
                card_view_answer1.setBackgroundResource(R.drawable.background_border_questions)
                answer1.setTextColor(Color.parseColor("#22d0c4"))
                card_view_answer2.setBackgroundResource(R.drawable.background_border)
                answer2.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer3.setBackgroundResource(R.drawable.background_border)
                answer3.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer4.setBackgroundResource(R.drawable.background_border)
                answer4.setTextColor(Color.parseColor("#991f314a"))
            }
            R.id.card_view_answer2 -> {
                submitbtn.isEnabled = true
                submitbtn.setBackgroundResource(R.drawable.background_button)
                card_view_answer2.setBackgroundResource(R.drawable.background_border_questions)
                answer2.setTextColor(Color.parseColor("#22d0c4"))
                card_view_answer1.setBackgroundResource(R.drawable.background_border)
                answer1.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer3.setBackgroundResource(R.drawable.background_border)
                answer3.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer4.setBackgroundResource(R.drawable.background_border)
                answer4.setTextColor(Color.parseColor("#991f314a"))
            }
            R.id.card_view_answer3 -> {
                submitbtn.isEnabled = true
                submitbtn.setBackgroundResource(R.drawable.background_button)
                card_view_answer3.setBackgroundResource(R.drawable.background_border_questions)
                answer3.setTextColor(Color.parseColor("#22d0c4"))
                card_view_answer1.setBackgroundResource(R.drawable.background_border)
                answer1.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer2.setBackgroundResource(R.drawable.background_border)
                answer2.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer4.setBackgroundResource(R.drawable.background_border)
                answer4.setTextColor(Color.parseColor("#991f314a"))
            }
            R.id.card_view_answer4 -> {
                submitbtn.isEnabled = true
                submitbtn.setBackgroundResource(R.drawable.background_button)
                card_view_answer4.setBackgroundResource(R.drawable.background_border_questions)
                answer4.setTextColor(Color.parseColor("#22d0c4"))
                card_view_answer1.setBackgroundResource(R.drawable.background_border)
                answer1.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer2.setBackgroundResource(R.drawable.background_border)
                answer2.setTextColor(Color.parseColor("#991f314a"))
                card_view_answer3.setBackgroundResource(R.drawable.background_border)
                answer3.setTextColor(Color.parseColor("#991f314a"))
            }
        }
    }

    private fun updateUI(save :String?){

        when(save){
            "Lesson 1"-> {
                segmentedProgressBar.setCompletedSegments(1)
            }
            "Lesson 2"-> {
                segmentedProgressBar.setCompletedSegments(2)
            }
            "Lesson 3"-> {
                segmentedProgressBar.setCompletedSegments(3)
            }
            "Lesson 4" ->{
                segmentedProgressBar.setCompletedSegments(4)
            }
        }
    }
}

