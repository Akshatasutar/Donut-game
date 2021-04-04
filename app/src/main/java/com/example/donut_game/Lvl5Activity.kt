package com.example.donut_game

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.FragmentManager
import com.github.chrisbanes.photoview.PhotoView
import com.github.chrisbanes.photoview.PhotoViewAttacher
import com.ortiz.touchview.TouchImageView

class Lvl5Activity : AppCompatActivity() {
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl5)
        playLvl5()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun playLvl5(){
        val donut5ImageView: TouchImageView = findViewById(R.id.lvl_5_donut_imageView)
        donut5ImageView.setImageResource(R.drawable.lvl_5_donut)
        donut5ImageView.maxZoom = 10.0f
        donut5ImageView.setScrollPosition(0.5f, 0.5f)

        donut5ImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.i("zsxf", "Zoom value = " + donut5ImageView.currentZoom)
                    if(donut5ImageView.currentZoom == donut5ImageView.maxZoom){
                        donut5ImageView.setImageResource(R.drawable.lvl_4_blank)
                        showLvl5ClearedDialog()
                    }
                }
            }
            view.invalidate()
            return@OnTouchListener true
        })
    }

    private fun showLvl5ClearedDialog(){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(5)?.show(fm, "fragment_level_cleared")
    }
}