package com.elfalt.ledo.ui

import android.content.ComponentCallbacks2
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        val lesson = intent.getStringExtra("lesson_num")
        lesson_quiz_num.text = "$lesson Quiz"

        submitbtn.setOnClickListener{

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.questions_group_dialog,null)

            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()

            mDialogView.agree_btn.setOnClickListener {
                val intent = Intent(this, CongratulationsActivity:: class.java)
                intent.putExtra("lesson",lesson)
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

    override fun onClick(v: View?) {
        val view = v!!.id
        when (view) {
            R.id.card_view_answer1 -> {
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
}

