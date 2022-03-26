package com.example.login

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.widget.EditText as EditText1
import android.widget.TextView as TextView1

class MainActivity : AppCompatActivity() {

    lateinit var Email: EditText1
    lateinit var Password: EditText1
    lateinit var Forgot: TextView1
    lateinit var LogIn: Button
    lateinit var SignUp: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        Email = findViewById(R.id.Email)
        Password = findViewById(R.id.Password)
        Forgot = findViewById(R.id.Forgot)
        LogIn = findViewById(R.id.LogIn)
        SignUp = findViewById(R.id.SignUp)
        auth = Firebase.auth

        LogIn.setOnClickListener {
            val etEmail = Email.text
            val etPassword = Password.text

            if(etEmail!=null && etPassword!=null && !etEmail.toString().isNullOrEmpty() && !etPassword.toString().isNullOrEmpty()) {
                auth.signInWithEmailAndPassword(etEmail.toString(), etPassword.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }
                }else{
                Toast.makeText(this, "Enter credentials", Toast.LENGTH_SHORT).show()
                }
        }

        Forgot.setOnClickListener {
            startActivity(Intent(this@MainActivity, ForgotPasswordActivity::class.java))
        }

        SignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    public override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if(currentUser!=null)
            updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }else{
            Toast.makeText(
                baseContext, "Login Failed",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}