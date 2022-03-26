package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    lateinit var Profile : TextView
    lateinit var LogOut : Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        Profile = findViewById(R.id.Profile)
        LogOut = findViewById(R.id.LogOut)

        var message =  FirebaseAuth.getInstance().currentUser?.email
        Profile.text = "Welcome back @${message.toString()}"

        LogOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            FirebaseAuth.getInstance().signOut()
            finish()
        }
    }
}