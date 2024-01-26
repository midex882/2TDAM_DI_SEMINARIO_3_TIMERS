package com.example.seminario_3

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio3 : AppCompatActivity(){

    lateinit var img : ImageView

    fun auto_timer(time: Long, light: Int){
        var ct = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                if(light == R.drawable.traffic_amber){
                    img.setImageDrawable(getDrawable(R.drawable.traffic_red))
                    auto_timer(2000, R.drawable.traffic_red)
                }else if(light == R.drawable.traffic_red){
                    img.setImageDrawable(getDrawable(R.drawable.traffic_green))
                    auto_timer(2000, R.drawable.traffic_green)
            }   else{
                    img.setImageDrawable(getDrawable(R.drawable.traffic_amber))
                    auto_timer(1000, R.drawable.traffic_amber)
                }
            }
        }.start()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio3)

        img = findViewById(R.id.light)
        img.setImageDrawable(getDrawable(R.drawable.traffic_green))

        auto_timer(2000, R.drawable.traffic_green)
    }
}