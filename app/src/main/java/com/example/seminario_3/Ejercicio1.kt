package com.example.seminario_3

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Ejercicio1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio1)

        var contador = 11
        var countDownText = findViewById<TextView>(R.id.countdownText)
        var layout = findViewById<ConstraintLayout>(R.id.background)

        var mediaPlayer : MediaPlayer

        fun play_sound(sound : Int )
        {
            mediaPlayer = MediaPlayer.create(this, sound)

            mediaPlayer?.start()
        }

        play_sound(R.raw.countdown)

        var ct = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                contador--
                if(contador < 10)
                {
                    countDownText.text = "0"+contador.toString()
                }else{
                    countDownText.text = contador.toString()
                }

            }
            override fun onFinish() {
                val intent = Intent(this@Ejercicio1, Saturn::class.java)
                startActivity(intent)
            }
        }.start()

    }
}