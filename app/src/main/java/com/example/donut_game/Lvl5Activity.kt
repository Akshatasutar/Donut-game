package com.example.donut_game

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager

class Lvl5Activity : AppCompatActivity() {
    private lateinit var doneButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl5)
        doneButton = findViewById(R.id.done_button_5)
    }

    fun onDoneButton5Pressed(v: View){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(5)?.show(fm, "fragment_level_cleared")
    }
}