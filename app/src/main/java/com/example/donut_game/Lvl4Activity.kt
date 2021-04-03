package com.example.donut_game

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class Lvl4Activity : AppCompatActivity() {
    private lateinit var doneButton: Button
    private lateinit var donut4ImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl4)
        doneButton = findViewById(R.id.done_button_4)
        donut4ImageView = findViewById(R.id.lvl_4_donut_imageView)

        playLevel3()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun playLevel3(){
        donut4ImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    val handler = Handler(Looper.getMainLooper())
                    handler.postDelayed(
                        Runnable {
                            donut4ImageView.setImageResource(R.drawable.lvl_4_donut_4)
                            handler.postDelayed(Runnable {
                                donut4ImageView.setImageResource(R.drawable.lvl_4_donut_5)
                            }, 1000)
                            handler.postDelayed(Runnable {
                                donut4ImageView.setImageResource(R.drawable.lvl_4_donut_7)
                            }, 1000)
                            handler.postDelayed(Runnable {
                                donut4ImageView.setImageResource(R.drawable.lvl_4_donut_9)
                            }, 1000)
                            handler.postDelayed(Runnable {
                                donut4ImageView.setImageResource(R.drawable.lvl_4_blank)
                            }, 1000)
                            /*
                            handler.postDelayed(Runnable {
                                showLevel4ClearedDialog(view)
                            }, 500)

                             */
                                 },
                        2000
                    )
                    //TODO:Close Runnables
                }
            }
            view.invalidate()
            return@OnTouchListener true
        })
    }

    fun showLevel4ClearedDialog(v: View){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(4)?.show(fm, "fragment_level_cleared")
    }
}