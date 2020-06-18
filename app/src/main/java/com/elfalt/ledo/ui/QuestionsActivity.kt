package com.elfalt.ledo.ui

import android.content.ComponentCallbacks2
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_questions.*
import kotlinx.android.synthetic.main.questions_group_dialog.view.*


class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


         card_view_answer1.setOnClickListener{

         }
        submitbtn.setOnClickListener{

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.questions_group_dialog,null)

            val mBuilder =AlertDialog.Builder(this)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()

            mDialogView.agreebtn.setOnClickListener {
                val intent = Intent(this, CongratulationsActivity:: class.java)
                startActivity(intent)

            }
            mDialogView.cancelbtn.setOnClickListener {
                mAlertDialog.dismiss()

            }
        }
    }
}
