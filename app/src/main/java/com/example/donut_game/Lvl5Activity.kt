package com.example.donut_game

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager

class Lvl5Activity : AppCompatActivity() {
    private lateinit var doneButton: Button
    private lateinit var donut5ImageView: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl5)
        doneButton = findViewById(R.id.done_button_5)
        donut5ImageView = findViewById(R.id.lvl_5_donut_imageView)
    }

    fun showLvl5ClearedDialog(v: View){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(5)?.show(fm, "fragment_level_cleared")
    }
}