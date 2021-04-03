package com.example.donut_game

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager

class Lvl4Activity : AppCompatActivity() {
    private lateinit var doneButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl4)
        doneButton = findViewById(R.id.done_button_4)
    }

    fun onDoneButton4Pressed(v: View){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(4)?.show(fm, "fragment_level_cleared")
    }
}