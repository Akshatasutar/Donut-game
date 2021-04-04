package com.example.donut_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //TODO: Disable back button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start_button)
    }

    fun onStartButtonPressed(v: View){
        val intent = Intent(this, Lvl5Activity::class.java)
        startActivity(intent)
    }
}