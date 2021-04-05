package com.example.donut_game

import android.R
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class Lvl1Activity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.donut_game.R.layout.activity_level1)
        val donutButton: ImageButton = findViewById(com.example.donut_game.R.id.donut_press_button)
        donutButton.setOnClickListener {
            count++
            val mp:MediaPlayer = MediaPlayer.create(this, com.example.donut_game.R.raw.tap_sound)
            mp.start()
            if(count == 4) {
                donutButton.setImageResource(com.example.donut_game.R.drawable.donut_half_eaten)
                val mp:MediaPlayer = MediaPlayer.create(this, com.example.donut_game.R.raw.eating)
                mp.start()
            }
            if(count >= 8){
                val mp:MediaPlayer = MediaPlayer.create(this, com.example.donut_game.R.raw.eating_finished)
                mp.start()
                donutButton.visibility = View.GONE
                showLvlClearedDialog()
            }
        }
    }

    private fun showLvlClearedDialog(){
        val fm:FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(1)?.show(fm, "fragment_level_cleared")
        val fragmentTransaction:FragmentTransaction = fm.beginTransaction()
        //fragmentTransaction.replace(R.id.fragment_container, InNeedFragment())
        fragmentTransaction.commit()
    }
}

