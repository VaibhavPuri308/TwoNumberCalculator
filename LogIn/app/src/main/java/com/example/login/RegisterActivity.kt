package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import android.widget.EditText as EditText1

class RegisterActivity : AppCompatActivity() {
    
    lateinit var EmailID : EditText1
    lateinit var PassWord : EditText1
    lateinit var ConfirmPassword : EditText1
    lateinit var Register : Button
    lateinit var Login : Button
    private lateinit var auth : FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        EmailID = findViewById(R.id.EmailID)
        PassWord = findViewById(R.id.PassWord)
        ConfirmPassword = findViewById(R.id.ConfirmPassword)
        Register = findViewById(R.id.Register)
        Login = findViewById(R.id.Login)

        auth = FirebaseAuth.getInstance();

        Register.setOnClickListener {
            if(EmailID.text.trim().isBlank()){
                Toast.makeText(this, "Enter your E-mail ID", Toast.LENGTH_LONG).show()
            }else if(PassWord.text.trim().isBlank()){
                Toast.makeText(this, "Enter your Password", Toast.LENGTH_LONG).show()
            }else if(ConfirmPassword.text.trim().isBlank()){
                Toast.makeText(this, "Enter your Confirm Password", Toast.LENGTH_LONG).show()
            }else if(PassWord.text.trim().isBlank()){
                Toast.makeText(this, "Enter your Password ID", Toast.LENGTH_LONG).show()
            }else if(PassWord.text.trim() != ConfirmPassword.text.trim()){
                Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_LONG).show()
            }else{
                createUser(EmailID.text.trim().toString(), PassWord.text.trim().toString())
            }
        }

        Login.setOnClickListener {
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
        }
    }

    fun createUser(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show()
                    Log.e("Task Message","Successful...");
                    if(email.isNotEmpty() && password.isNotEmpty()) {
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task1 ->
                                if (task1.isSuccessful) {
                                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                                    val user = auth.currentUser
                                    updateUI(user)
                                } else {
                                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task1.exception)
                                    Toast.makeText(
                                        baseContext, "Authentication failed.",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                    }else{
                        Toast.makeText(this, "Enter credentials", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, task.exception?.toString() , Toast.LENGTH_SHORT).show()
                    Log.e("Task Message","Failed..." + task.exception);
                    if(task.exception is FirebaseAuthUserCollisionException){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
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