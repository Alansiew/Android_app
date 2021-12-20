package com.example.aplikacja7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import kotlin.math.ln
import kotlin.math.roundToInt

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var buttonOblicz = findViewById<Button>(R.id.buttonOblicz)
        val kond1 = findViewById<TextView>(R.id.kond1)
        val kond2 = findViewById<TextView>(R.id.kond2)
        val kond3 = findViewById<TextView>(R.id.kond3)
        val Vbufor = findViewById<TextView>(R.id.Vbufor)
        var textAnserw = findViewById<TextView>(R.id.textAnswer)

        buttonOblicz.setOnClickListener {
            try {
                val firstVal: String = kond1.text.toString()
                val secondVal: String = kond2.text.toString()
                val thirdVal: String = kond3.text.toString()
                val fourthVal: String = Vbufor.text.toString()
                val result1: Double = subtract(firstVal, secondVal)
                val result2: Double = subctract2(firstVal, thirdVal)
                val result3: Double = divide(result2, result1)
                val result4: Double = ln1(result3)
                val result5: Double = solution(fourthVal, result4).toDouble()
                textAnserw.setText("Trzeba dodać " + result5 + " L buforu")
            }catch (e: Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
            }


        }

    }



// funkcja odejmowania (konduktancja pozadana minus konduktancja buforu)
    private fun subtract(firstVal: String, secondVal: String): Double {

        val a: Double = firstVal.toDouble()
        val b:Double = secondVal.toDouble()

        val sum: Double = b-a

        return sum

    }
    //funkcja odejmowania (konduktancja buforu minus aktualna konduktancja)
    private fun subctract2(firstVal: String,thirdVal: String): Double {

        val b:Double = firstVal.toDouble()
        val a:Double = thirdVal.toDouble()


        val sum1:Double = a-b

        return sum1

    }
// funkcja dzielenia (dzielenie powyzszych wynikow odejmowania)
    private fun divide(result2: Double, result1: Double): Double {
        val a: Double = result2
        val b: Double = result1

        val sum:Double = a/b

        return sum
    }
// logarytm naturalny z podzielonego wyniku
    private fun ln1(result3: Double): Double {
        val b:Double = result3
        val sum:Double = ln(b)
        return sum
    }
// logarytm pomnozony przez objetosc materialu
    private fun solution(fourthVal: String, result4: Double): Int {
        val a: Double = fourthVal.toDouble()
        val b:Double = result4

        val sum: Double = a*b

        return sum.roundToInt()
    }

}

