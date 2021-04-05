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

class Lvl3Activity : AppCompatActivity() {
    private lateinit var doneButton: Button
    private lateinit var donut4ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl4)
        donut4ImageView = findViewById(R.id.lvl_4_donut_imageView)

        playLevel3()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun playLevel3(){
        val handler = Handler(Looper.getMainLooper())

        val runnable2 = Runnable {
            donut4ImageView.setImageResource(R.drawable.lvl_4_donut_9)
        }
        val runnable3 = Runnable {
            donut4ImageView.setImageResource(R.drawable.lvl_4_blank)
        }
        val runnable4 = Runnable {
            showLevel4ClearedDialog()
        }
        val runnable1 = Runnable {
            donut4ImageView.setImageResource(R.drawable.lvl_4_donut_7)
            handler.postDelayed(runnable2, 1000)
            Thread(runnable2).interrupt()

            handler.postDelayed(runnable3, 1000)
            Thread(runnable3).interrupt()

            handler.postDelayed(runnable4, 1000)
            Thread(runnable4).interrupt()
        }

        donut4ImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                //When user presses on screen:
                MotionEvent.ACTION_DOWN -> {
                    handler.postDelayed(
                        Runnable {
                            donut4ImageView.setImageResource(R.drawable.lvl_4_donut_4)
                            handler.postDelayed(Runnable {
                                donut4ImageView.setImageResource(R.drawable.lvl_4_donut_5)
                                handler.postDelayed(runnable1, 1000)
                                Thread(runnable1).interrupt()
                            }, 1000)
                        },
                        2000
                    )
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