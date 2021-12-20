package com.example.aplikacja7


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val MainActivityBtn = findViewById<Button>(R.id.MainActBtn)
        // Przycisk, który przenosi do kolejnego layautu
        MainActivityBtn.setOnClickListener {

            val Intent = Intent(this,FirstActivity::class.java)

            startActivity(Intent)


        }
        val CheckActivityBtn = findViewById<Button>(R.id.CheckBtn)
        // Przycisk, który przenosi do kolejnego layautu
        CheckActivityBtn.setOnClickListener {

            val Intent = Intent(this,FifthActivity::class.java)

            startActivity(Intent)

        }
    }
}








