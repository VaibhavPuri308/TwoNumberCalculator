package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.twonumbercalculator.R
import android.widget.Button as Button1

class MainActivity : AppCompatActivity() {

    lateinit var FirstNumber : EditText
    lateinit var SecondNumber : EditText
    lateinit var AnsStatement : TextView
    lateinit var Answer : TextView
    lateinit var Addition : Button1
    lateinit var Subtraction : Button1
    lateinit var Multiplication : Button1
    lateinit var Division : Button1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirstNumber = findViewById(R.id.FirstNumber)
        SecondNumber = findViewById(R.id.SecondNumber)
        AnsStatement = findViewById(R.id.AnsStatement)
        Answer = findViewById(R.id.Answer)
        Addition = findViewById(R.id.Addition)
        Subtraction = findViewById(R.id.Subtraction)
        Multiplication = findViewById(R.id.Multiplication)
        Division = findViewById(R.id.Division)

        Addition.setOnClickListener{
            val num1 = FirstNumber.text.toString().toInt()
            val num2 = SecondNumber.text.toString().toInt()
            val result = num1 + num2
            Answer.text = result.toString()
        }

        Subtraction.setOnClickListener{
            val num1 = FirstNumber.text.toString().toInt()
            val num2 = SecondNumber.text.toString().toInt()
            val result = num1 - num2
            Answer.text = result.toString()
        }

        Multiplication.setOnClickListener{
            val num1 = FirstNumber.text.toString().toInt()
            val num2 = SecondNumber.text.toString().toInt()
            val result = num1 * num2
            Answer.text = result.toString()
        }

        Division.setOnClickListener{
            val num1 = FirstNumber.text.toString().toInt()
            val num2 = SecondNumber.text.toString().toInt()
            val result = num1 / num2
            Answer.text = result.toString()
        }
    }
}