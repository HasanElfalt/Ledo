package com.elfalt.ledo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.elfalt.ledo.LoginScreen
import com.elfalt.ledo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logintxt.setOnClickListener {
            val intent = Intent(this, LoginScreen:: class.java)
            startActivity(intent)
        }
        getStarted.setOnClickListener {
            val intent = Intent(this, HomeScreenActivity:: class.java)
            startActivity(intent)
        }
    }



}
