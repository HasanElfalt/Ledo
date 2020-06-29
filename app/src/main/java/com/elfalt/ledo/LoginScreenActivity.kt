package com.elfalt.ledo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elfalt.ledo.ui.HomeScreenActivity
import com.elfalt.ledo.ui.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_register.*


class LoginScreenActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference
    lateinit var emailLogin: TextInputLayout
    lateinit var passwordLogin: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        CancelRegister.setOnClickListener {
            val intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }

        mAuth = FirebaseAuth.getInstance()

        mDatabase = FirebaseDatabase.getInstance().getReference("Usernames")

        emailLogin = findViewById(R.id.Email_login)
        passwordLogin = findViewById(R.id.Password)

        loginbtn.setOnClickListener {

            val email = emailLogin.editText?.text.toString().trim()
            val password = passwordLogin.editText?.text.toString().trim()

            if (email.isEmpty()) {
                emailLogin.error = "Field can not be Empty"
                return@setOnClickListener

            } else {
                emailLogin.isErrorEnabled = false
            }
            if (password.isEmpty()) {
                passwordLogin.error = "Field can not be Empty"
                return@setOnClickListener
            } else {

                passwordLogin.isErrorEnabled = false

            }
            
            loginUser(email,password)
        }
    }


    private fun loginUser(email:String,password:String)
    {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this,  OnCompleteListener {task->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, HomeScreenActivity::class.java))
                        Toast.makeText(this, "Successfully Log in", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this, "Error Log in, try again", Toast.LENGTH_LONG).show()
                    }
            })

    }

}