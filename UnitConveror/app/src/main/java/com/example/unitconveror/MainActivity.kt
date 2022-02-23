package com.example.unitconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitconveror.R
import android.widget.Button as Button1
import android.widget.EditText as EditText1
import android.widget.TextView as TextView1

class MainActivity : AppCompatActivity() {

    lateinit var Number : EditText1
    lateinit var PoundtoKilogram : Button1
    lateinit var KilogramtoPound : Button1
    lateinit var LitretoGalon : Button1
    lateinit var GalontoLitre : Button1
    lateinit var InchtoCentimeter : Button1
    lateinit var CentimetertoInch : Button1
    lateinit var Answer : TextView1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Number = findViewById(R.id.Number)
        PoundtoKilogram = findViewById(R.id.PoundtoKilogram)
        KilogramtoPound = findViewById(R.id.KilogramtoPound)
        LitretoGalon = findViewById(R.id.LitretoGallon)
        GalontoLitre = findViewById(R.id.GallontoLitre)
        InchtoCentimeter = findViewById(R.id.InchtoCentimeter)
        CentimetertoInch = findViewById(R.id.CentimetertoInch)
        Answer = findViewById(R.id.Answer)

        PoundtoKilogram.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 / 0.453592
            Answer.text = result.toString()
        }

        KilogramtoPound.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 * 0.453592
            Answer.text = result.toString()
        }

        LitretoGalon.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 / 0.219969
            Answer.text = result.toString()
        }

        GalontoLitre.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 * 0.219969
            Answer.text = result.toString()
        }

        InchtoCentimeter.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 * 0.393701
            Answer.text = result.toString()
        }

        CentimetertoInch.setOnClickListener{
            val num1 = Number.text.toString().toInt()
            val result = num1 / 0.393701
            Answer.text = result.toString()
        }
    }
}