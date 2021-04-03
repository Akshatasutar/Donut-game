package com.example.donut_game

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlin.properties.Delegates

class LevelClearedDialog: DialogFragment() {
    private lateinit var intent:Intent
    private var lvl by Delegates.notNull<Int>()

    companion object {
        const val TAG = "LevelCompletedDialog"
        val messages = listOf<String>("*burp!* That was delicious.", "Oh! Sweet discs of happiness",
                "Mmm Mm mm! More!", "I donut share!", "My sweet tooth is satisfied",
                "Hot, soft and smelled like cake. Perfect!", "This is what heaven must taste like", "Yeah you got that yummy yum.. ",
                "Yum! That was fresh out of the oven", "How many donuts is too many? Don't answer that.")
    }

    fun newInstance(lvl: Int): LevelClearedDialog? {
        val frag = LevelClearedDialog()
        val args = Bundle()
        args.putInt("levelNumber", lvl)
        frag.arguments = args
        return frag
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.activity_level_cleared, container, false)
        val levelClearedTextView: TextView = view.findViewById(R.id.level_completed_textView)
        val congratsTextView: TextView = view.findViewById(R.id.congrats_textView)
        val nextLvlButton: ImageButton = view.findViewById(R.id.next_imageButton)

        lvl = arguments?.getInt("levelNumber")!!
        congratsTextView.text = messages[lvl - 1]
        levelClearedTextView.text = " L e v e l   $lvl   c l e a r e d "

        nextLvlButton.setOnClickListener {
            //val intent = Intent(context, Lvl2Activity::class.java)
            goToNextLvl()
            startActivity(intent)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window
        dialog?.setCanceledOnTouchOutside(false)
    }

    private fun goToNextLvl(){
        when(lvl) {
            1 -> intent = Intent(context, Lvl2Activity::class.java)
            2 -> intent = Intent(context, Lvl3Activity::class.java)
            3 -> intent = Intent(context, Lvl4Activity::class.java)
            4 -> intent = Intent(context, Lvl5Activity::class.java)
            else -> {intent = Intent(context, EndOfGameActivity::class.java)}
        }
    }

}