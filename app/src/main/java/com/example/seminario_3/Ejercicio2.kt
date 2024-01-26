package com.example.seminario_3

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio2)

        var board = findViewById<LinearLayout>(R.id.board)
        var cartas = mutableListOf<Carta>()
        var cartas_imagenes = resources.obtainTypedArray(R.array.cards)
        var cartas_imagenes_final = mutableListOf<Int>()
        var cartas_levantadas = mutableListOf<Carta>()
        var turno = true
        var mediaPlayer : android.media.MediaPlayer? = null

        fun play_sound(sound : Int )
        {
            mediaPlayer = MediaPlayer.create(this, sound)

            mediaPlayer?.start()
        }




        //INICIALIZAR CARTAS
        var k = 0

        for (i in 1 until cartas_imagenes.length()) {
            cartas_imagenes_final.add(cartas_imagenes.getResourceId(i, R.drawable.c0))
            cartas_imagenes_final.add(cartas_imagenes.getResourceId(i, R.drawable.c0))
        }

        cartas_imagenes_final.shuffle()


        for (i in 0 until board.childCount) {

            var c = Carta(cartas_imagenes_final[k], board.getChildAt(i) as ImageView)

            c.view.setOnClickListener {
                if(turno && cartas_levantadas.size < 2 && !c.levantada)
                {
                    turno = false
                    play_sound(R.raw.flip)
                    c.flip()
                    cartas_levantadas.add(c)

                    var ct = object : CountDownTimer(1000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                        }
                        override fun onFinish() {
                            cartas_levantadas[0].unflip(cartas_levantadas[0].view)
                            cartas_levantadas = mutableListOf()
                            turno = true
                        }
                    }.start()

//                    Handler(Looper.getMainLooper()).postDelayed({
//                        cartas_levantadas[0].unflip(cartas_levantadas[0].view)
//                        cartas_levantadas = mutableListOf()
//                        turno = true
//                    }, 1000)

                }
            }

            cartas.add(Carta(cartas_imagenes_final[k], board.getChildAt(i) as ImageView))
            k++
        }

    }
}