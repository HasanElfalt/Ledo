package com.elfalt.ledo


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    lateinit var mDatabase: DatabaseReference

    lateinit var emailRegister    : TextInputLayout
    lateinit var usernameRegister : TextInputLayout
    lateinit var passwordRegister : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        CancelRegister.setOnClickListener {
            finish()
        }
        mAuth = FirebaseAuth.getInstance()

        mDatabase = FirebaseDatabase.getInstance().getReference("Usernames")

        emailRegister = findViewById(R.id.Email)
        usernameRegister = findViewById(R.id.UsernameRegister)
        passwordRegister = findViewById(R.id.PasswordRegister)

        Registerbtn.setOnClickListener {

            val emailregister = emailRegister.editText?.text.toString().trim()
            val usernameregister = usernameRegister.editText?.text.toString().trim()
            val passwordregister = passwordRegister.editText?.text.toString().trim()

            if (emailregister.isEmpty() ) {
                emailRegister.error="Field can not be Empty"
                return@setOnClickListener

            }else{
                emailRegister.isErrorEnabled=false
            }
            if(usernameregister.isEmpty()) {
                usernameRegister.error="Field can not be Empty"
                return@setOnClickListener
            }else{

                usernameRegister.isErrorEnabled=false

            }
            if(passwordregister.isEmpty()) {
                passwordRegister.error="Field can not be Empty"
                return@setOnClickListener
            }else{

                passwordRegister.isErrorEnabled=false
            }

                registerUser(emailregister,usernameregister,passwordregister)
        }
    }
    private fun registerUser (email:String, username:String, password:String) {
        mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(OnCompleteListener { task ->

            if (task.isSuccessful) {
               val user = mAuth.currentUser
                val uid = user!!.uid
                mDatabase.child(uid).child("Username").setValue(username)
                startActivity(Intent(this, LoginScreenActivity::class.java))
                Toast.makeText(this, "Successfully Registered :)", Toast.LENGTH_LONG).show()
                finish()
            }else {
                Toast.makeText(this, "Error Registering, try again", Toast.LENGTH_LONG).show()
            }
        })

    }

}