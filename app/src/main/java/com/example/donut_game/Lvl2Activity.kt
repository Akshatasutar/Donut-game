package com.example.donut_game

import android.annotation.SuppressLint
import android.graphics.*
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager

class Lvl2Activity : AppCompatActivity() {
    private lateinit var doneButton:Button
    private val mDestPath = Path()
    private var mSourceCanvas = Canvas()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl2)
        doneButton = findViewById(R.id.done_button)
        val donut2ImageView:ImageView = findViewById(R.id.lvl_2_donut_imageView)
        //donut2ImageView.setImageBitmap(pictureToErase())

        /*
        donut2ImageView.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            var xPos: Float = motionEvent.x
            var yPos: Float = motionEvent.y
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    mDestPath.moveTo(xPos, yPos)
                }
                MotionEvent.ACTION_MOVE -> {
                    mDestPath.lineTo(xPos, yPos)
                }
            }
            return@OnTouchListener true
        })
        donut2ImageView.onDrawForeground(mSourceCanvas)
         */
        val donutView = Lvl2DonutView(this)
        val rootLayout: ConstraintLayout = findViewById(R.id.lvl_2_root_layout)
        rootLayout.addView(donutView)
    }

    @SuppressLint("ResourceAsColor")
    private fun pictureToErase():Bitmap?{
        //convert drawable file into bitmap
        val rawBitmap =
            BitmapFactory.decodeResource(this.resources, R.drawable.lvl_2_donut)
        //convert bitmap into mutable bitmap
        val mBitmap = rawBitmap.copy(Bitmap.Config.ARGB_8888, true)

        Log.i("kxjdhcb", "IsMutable:" + mBitmap.isMutable)

        //Paint to erase
        val paint = Paint().apply {
            isAntiAlias = true
            xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            style = Paint.Style.STROKE
            strokeWidth = 200f
            alpha = 0
        }

        //Canvas for drawing - set bitmap on canvas
        mSourceCanvas.setBitmap(mBitmap)
        return mBitmap
    }

    fun onDoneButtonPressed(v: View){
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.eating_finished)
        mp.start()
        val fm: FragmentManager = supportFragmentManager
        LevelClearedDialog().newInstance(2)?.show(fm, "fragment_level_cleared")
    }

}