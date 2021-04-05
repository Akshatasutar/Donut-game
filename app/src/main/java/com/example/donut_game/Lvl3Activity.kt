package com.example.donut_game

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class Lvl3Activity : AppCompatActivity() {
    private lateinit var donut4ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl4)
        donut4ImageView = findViewById(R.id.lvl_4_donut_imageView)
        donut4ImageView.setBackgroundResource(R.drawable.lvl_4_donut)
        
        playLevel3()
    }

    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables")
    private fun playLevel3(){
        var disappearAnim:AnimationDrawable
        donut4ImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> run {
                    donut4ImageView.setBackgroundResource(R.drawable.disappearing_image)
                    disappearAnim = donut4ImageView.background as AnimationDrawable
                    disappearAnim.start()
                }
                MotionEvent.ACTION_UP -> run {
                    disappearAnim = donut4ImageView.background as AnimationDrawable
                    disappearAnim.stop()
                    var lastFrame: Drawable = disappearAnim.getFrame(disappearAnim.numberOfFrames - 1)
                    if(disappearAnim.current == lastFrame){
                        showLevel4ClearedDialog()
                    }
                }
            }
            view.invalidate()
            return@OnTouchListener true
        })
    }

    private fun showLevel4ClearedDialog(){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(3)?.show(fm, "fragment_level_cleared")
    }
}