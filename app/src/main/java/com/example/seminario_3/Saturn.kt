package com.example.seminario_3

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Saturn : AppCompatActivity() {

    lateinit var mediaPlayer : MediaPlayer

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.saturn)





        fun play_sound(sound : Int )
        {
            mediaPlayer = MediaPlayer.create(this, sound)

            mediaPlayer?.start()
        }

        play_sound(R.raw.saturn_def)

    }
}