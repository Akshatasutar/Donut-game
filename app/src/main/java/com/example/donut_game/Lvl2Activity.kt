package com.example.donut_game

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager

class Lvl2Activity : AppCompatActivity() {
    private lateinit var lvl3DonutImageView:ImageView
    var xDown = 0f
    var yDown = 0f
    var hasEntered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl3)
        lvl3DonutImageView = findViewById(R.id.lvl_3_donut_imageView)

        playLevel3()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun playLevel3(){
        lvl3DonutImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    xDown = motionEvent.x
                    yDown = motionEvent.y
                }
                MotionEvent.ACTION_MOVE -> {
                    var xMoved: Float = motionEvent.x
                    var yMoved: Float = motionEvent.y

                    var xDistance:Float = xMoved - xDown
                    var yDistance:Float = yMoved - yDown

                    lvl3DonutImageView.x = lvl3DonutImageView.x + xDistance
                    lvl3DonutImageView.y = lvl3DonutImageView.y + yDistance
                    Log.i("kdjnhfb", "x, y = (" + lvl3DonutImageView.x + ", " + lvl3DonutImageView.y + ")")

                    val rootLayout: ConstraintLayout = findViewById(R.id.lvl_3_layout)
                    rootLayout.measure(0,0)
                    lvl3DonutImageView.measure(0,0)
                    val posEndX = rootLayout.measuredWidth.toFloat() + rootLayout.measuredWidth.toFloat()/8  //-560 to 968
                    val posEndY = rootLayout.measuredHeight.toFloat() + rootLayout.measuredHeight/2.toFloat()  //-568 to 1750
                    val negEndX = -lvl3DonutImageView.measuredWidth.toFloat()
                    val negEndY = -lvl3DonutImageView.measuredHeight.toFloat()
                    //824 - screen width, 282 - image width
                    //1109 - screen height, 262 - image height
                    if(lvl3DonutImageView.x !in -560.0f..posEndX || lvl3DonutImageView.y !in -568.0f..posEndY) {
                        if (!hasEntered){
                            levelComplete()
                        }
                    }
                }
            }
            view.invalidate()
            return@OnTouchListener true
        })
    }

    private fun levelComplete(){
        hasEntered = true
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        lvl3DonutImageView.visibility = View.GONE
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(2)?.show(fm, "fragment_level_cleared")
    }
}

