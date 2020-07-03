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
import com.google.firebase.auth.FirebaseUser
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

        forgot_password_txt.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        Registertxt.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
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
            .addOnCompleteListener(OnCompleteListener {task->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Successfully log in", Toast.LENGTH_SHORT).show()
                        val user =mAuth.currentUser
                        updateUI(user)
                    }else {
                        updateUI(null)
                    }
            })

    }

    public override fun onStart() {
        super.onStart()

        val currentUser = mAuth.currentUser
        updateUI(currentUser)
    }


    fun updateUI(currentUsers: FirebaseUser?) {

        if (currentUsers!=null){
            if (currentUsers.isEmailVerified) {
                startActivity(Intent(this, HomeScreenActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Please verify your email address", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Login failed.", Toast.LENGTH_SHORT).show()
        }
    }
}