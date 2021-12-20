package com.example.aplikacja7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        var buttonObliczMol = findViewById<Button>(R.id.buttonObliczMol)
        val mol_Roztwor = findViewById<TextView>(R.id.mol_roztwor)
        val stock = findViewById<TextView>(R.id.stock)
        val vRoztwor = findViewById<TextView>(R.id.vRoztwor)
        var textAnserwRoztwor = findViewById<TextView>(R.id.textAnserwRoztwor)

        buttonObliczMol.setOnClickListener {
            try {
                val firstVal: String = mol_Roztwor.text.toString()
                val secondVal: String = stock.text.toString()
                val thirdVal: String = vRoztwor.text.toString()
                val result1: Double = divide(firstVal, secondVal)
                val result2: Double = solution(result1, thirdVal)
                val result3: Double = water(thirdVal, result2)




                if(firstVal<secondVal){
                textAnserwRoztwor.setText("Trzeba dodać "+result2+" L stocku, do "+result3+" L wody")
            }else{
                    Toast.makeText(this,"Cm stocku nie moze byc mniejsze od Cm roztworu",Toast.LENGTH_SHORT).show()

                }

            }catch (e: Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
            }

        }
    }


//funkcja mnozenia
    private fun solution(result1: Double, thirdVal: String): Double {
        val a: Double = thirdVal.toDouble()
        val b:Double = result1

        val sum: Double = a*b

        return sum
    }
// funkcja dzielenia
    private fun divide(firstVal: String, secondVal: String): Double {
        val a: Double = firstVal.toDouble()
        val b: Double = secondVal.toDouble()

        val sum:Double = a/b

        return sum

    }
    //wynik ile wody jest potrzebne do uzyskania pozadanego Cm
    private fun water(thirdVal: String, result2: Double): Double {
        val a: Double = thirdVal.toDouble()
        val b:Double = result2

        val sum: Double = a-b

        return sum
    }
}
