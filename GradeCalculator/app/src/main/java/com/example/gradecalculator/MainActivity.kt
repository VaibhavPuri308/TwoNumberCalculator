package com.example.averageofmarks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gradecalculator.R
import android.widget.EditText as EditText1
import android.widget.TextView as TextView1

class MainActivity : AppCompatActivity() {

    lateinit var SubjectAMarks : EditText1
    lateinit var SubjectBMarks : EditText1
    lateinit var SubjectCMarks : EditText1
    lateinit var SubjectDMarks : EditText1
    lateinit var SubjectEMarks : EditText1
    lateinit var AverageMarks : Button
    lateinit var Average : TextView1
    lateinit var CGPA : TextView1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SubjectAMarks = findViewById(R.id.SubjectAMarks)
        SubjectBMarks = findViewById(R.id.SubjectBMarks)
        SubjectCMarks = findViewById(R.id.SubjectCMarks)
        SubjectDMarks = findViewById(R.id.SubjectDMarks)
        SubjectEMarks = findViewById(R.id.SubjectEMarks)
        AverageMarks = findViewById(R.id.AverageMarks)
        Average = findViewById(R.id.Average)
        CGPA = findViewById(R.id.CGPA)

        AverageMarks.setOnClickListener {

            val num1 = SubjectAMarks.text.toString().toInt()
            val num2 = SubjectBMarks.text.toString().toInt()
            val num3 = SubjectCMarks.text.toString().toInt()
            val num4 = SubjectDMarks.text.toString().toInt()
            val num5 = SubjectEMarks.text.toString().toInt()
            val result = ( num1 + num2 + num3 + num4 + num5 ) / 5

            Average.setText(result.toString())

            val Pointers = if ( result >= 91 )
                " 10 "
            else if ( result >= 81 )
                " 9 "
            else if ( result >= 71 )
                " 8 "
            else if ( result >= 61 )
                " 7 "
            else if ( result >= 51 )
                " 6 "
            else if ( result >= 45 )
                " 5 "
            else if ( result >= 41 )
                " 4 "
            else
                " Fail "

            CGPA.setText(Pointers.toString())

        }
    }
}