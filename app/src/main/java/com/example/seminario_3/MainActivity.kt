package com.example.seminario_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ejercicio1 = findViewById<Button>(R.id.ejercicio1)
        var ejercicio2 = findViewById<Button>(R.id.ejercicio2)
        var ejercicio3 = findViewById<Button>(R.id.ejercicio3)

        ejercicio1.setOnClickListener {
            var intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }

        ejercicio2.setOnClickListener {
            var intent = Intent(this, Ejercicio2::class.java)
            startActivity(intent)
        }

        ejercicio3.setOnClickListener {
            var intent = Intent(this, Ejercicio3::class.java)
            startActivity(intent)
        }
    }
}