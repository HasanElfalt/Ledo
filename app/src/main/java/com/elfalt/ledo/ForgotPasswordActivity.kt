package com.elfalt.ledo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elfalt.ledo.ui.HomeScreenActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    lateinit var emailForgot: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        mAuth = FirebaseAuth.getInstance()
        emailForgot = findViewById(R.id.forgot_email)

        sendbtn.setOnClickListener {
            val email = emailForgot.editText?.text.toString().trim()

            if (email.isEmpty()) {
                emailForgot.error = "Field can not be Empty"
                return@setOnClickListener

            } else {
                emailForgot.isErrorEnabled = false
            }

            forgotPassword(email)
        }
    }

        private fun forgotPassword(email: String) {
            mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, LoginScreenActivity::class.java))
                        Toast.makeText(this, "Email Send", Toast.LENGTH_SHORT).show()
                        finish()
                    }else {
                        Toast.makeText(this, "Error Forgot Password, try again", Toast.LENGTH_SHORT).show()
                    }
                })
        }

}
