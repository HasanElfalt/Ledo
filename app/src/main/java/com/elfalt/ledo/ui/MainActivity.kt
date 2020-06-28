package com.elfalt.ledo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elfalt.ledo.LoginScreenActivity
import com.elfalt.ledo.R
import com.elfalt.ledo.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        Registertxt.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        logintxt.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
        }
        getStarted.setOnClickListener {
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }


   public override fun onStart() {
        super.onStart()

        val currentUser = mAuth.currentUser
        if(currentUser==null)
        {

        }else{

        }

       }


    fun updateUI(currentUsers: FirebaseUser?){

}

    }


