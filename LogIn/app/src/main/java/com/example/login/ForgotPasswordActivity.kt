package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var eTEmail : EditText
    lateinit var btnsendemail : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        eTEmail=findViewById(R.id.eTEmail)
        btnsendemail=findViewById(R.id.btnsendemail)

        btnsendemail.setOnClickListener {
            val email : String = eTEmail.text.toString().trim{it <= ' '}
            if(email.isEmpty()) {
                Toast.makeText(
                    this@ForgotPasswordActivity,"Enter your registered E-mail ID",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "E-mail to reset password is sent successfully",
                                Toast.LENGTH_LONG
                            ).show()
                            finish()
                        }else{
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
        }

    }
}