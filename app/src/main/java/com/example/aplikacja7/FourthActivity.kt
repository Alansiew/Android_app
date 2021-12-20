package com.example.aplikacja7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.itextpdf.awt.geom.Line2D
import kotlin.math.roundToInt

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        var buttonObliczZageszczenie = findViewById<Button>(R.id.buttonObliczZageczszenie)
        val gramMaterial = findViewById<TextView>(R.id.gramMaterial)
        val vMaterial = findViewById<TextView>(R.id.vMaterial)
        var textAnserwZageszczenie = findViewById<TextView>(R.id.textAnserwZageszczenie)


        buttonObliczZageszczenie.setOnClickListener {
            try {
            val firstVal:String = gramMaterial.text.toString()
            val secondVal:String = vMaterial.text.toString()
            var stala:Double = 45.5
            val result1:Double = multiply(firstVal,secondVal)
            val solution:Double = divide(result1,stala)
            textAnserwZageszczenie.setText("Trzeba zagescic do "+solution+" L materialu")
            }
            catch (e: Exception)
            {Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()}
        }
    }

    private fun divide(result1: Double, stala: Double): Double {
        val a: Double = result1
        val b:Double = stala

        val sum: Double = a/b;
        val sum2 = Math.round(sum*100)/100.0 //zaokragla do dwoch miejsc po przecinku

        return sum2
    }

    private fun multiply(firstVal: String, secondVal: String): Double {
        val a: Double = firstVal.toDouble()
        val b:Double = secondVal.toDouble()

        val sum: Double = b*a;

        return sum
    }
}