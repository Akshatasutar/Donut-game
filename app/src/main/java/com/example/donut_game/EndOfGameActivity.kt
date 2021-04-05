package com.example.donut_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.ortiz.touchview.TouchImageView

class EndOfGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_of_game)
        //TODO:Animate so the text appears one after the other
        val akDonutImageView: TouchImageView = findViewById(R.id.ak_donut_imageView)
        akDonutImageView.setImageResource(R.drawable.akshu_donut)

        val viewIds = listOf<Int>(R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5, R.id.ak_donut_imageView)
        for ((i, viewId) in viewIds.withIndex()) {
            val fadeAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.fading_effect)
            fadeAnimation.startOffset = i*1800.toLong()

            if(i != 4) {
                val textView: TextView = findViewById(viewId)
                textView.startAnimation(fadeAnimation)
            }
            else{
                val imgView: TouchImageView = findViewById(viewId)
                imgView.startAnimation(fadeAnimation)
            }
        }
    }
}