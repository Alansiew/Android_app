package com.example.aplikacja7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val secondActBtn = findViewById<Button>(R.id.secondActivityBtn)
        // Przycisk, który przenosi do kolejnego layautu
        secondActBtn.setOnClickListener {

            val Intent = Intent(this,SecondActivity::class.java)

            startActivity(Intent)


        }
        val thirdActBtn = findViewById<Button>(R.id.thirdActivityButton)
        // Przycisk, który przenosi do kolejnego layautu
        thirdActBtn.setOnClickListener{
            val Intent2 = Intent(this,ThirdActivity::class.java)

            startActivity(Intent2)
        }
        val fourthActBtn = findViewById<Button>(R.id.fourthActivityButton)
        // Przycisk, który przenosi do kolejnego layautu
        fourthActBtn.setOnClickListener{
            val Intent3 = Intent(this,FourthActivity::class.java)

            startActivity(Intent3)
        }
        val sixthActBtn = findViewById<Button>(R.id.sixthActivityButton)
        // Przycisk, który przenosi do kolejnego layautu
        sixthActBtn.setOnClickListener{
            val Intent4 = Intent(this,SixthActivity::class.java)

            startActivity(Intent4)
        }
    }
}