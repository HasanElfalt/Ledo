package com.elfalt.ledo


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elfalt.ledo.ui.HomeScreenActivity
import com.elfalt.ledo.ui.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()


        mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        Registerbtn.setOnClickListener {
            registerUser()
        }
    }
        private fun registerUser () {
            val emailRegister=findViewById<TextInputLayout>(R.id.Email)
            val usernameRegister = findViewById<TextInputLayout>(R.id.UsernameRegister)
            val passwordRegister = findViewById<TextInputLayout>(R.id.PasswordRegister)

            val email = emailRegister.editText.toString().trim()
            val usernameregister = usernameRegister.editText.toString().trim()
            val passwordregister = passwordRegister.editText.toString().trim()


            if (!email.isEmpty() && !usernameregister.isEmpty() && !passwordregister.isEmpty()) {
                mAuth.createUserWithEmailAndPassword(email, passwordregister).addOnCompleteListener(this, OnCompleteListener { task ->

                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Name").setValue(usernameregister)
                    startActivity(Intent(this, LoginScreenActivity::class.java))
                    Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                }
            })
                }else {
                    Toast.makeText(this,"Please fill up the Credentials :|", Toast.LENGTH_LONG).show()
                }
            }

        }


