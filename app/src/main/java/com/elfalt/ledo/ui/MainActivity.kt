package com.elfalt.ledo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elfalt.ledo.LoginScreenActivity
import com.elfalt.ledo.R
import com.elfalt.ledo.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Registertxt.setOnClickListener {
            val intent = Intent(this, RegisterActivity:: class.java)
            startActivity(intent)
        }

        logintxt.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity:: class.java)
            startActivity(intent)
        }
        getStarted.setOnClickListener {
            val intent = Intent(this, HomeScreenActivity:: class.java)
            startActivity(intent)
        }
    }



}
