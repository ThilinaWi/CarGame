package com.example.cargame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(),GameTask {
    lateinit var rootLayout: LinearLayout
    lateinit var startBtn:Button
    lateinit var mGameView: GameView
    lateinit var score:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this,this)


        startBtn.setOnClickListener{
            if (mGameView.parent != null) {
                (mGameView.parent as ViewGroup).removeView(mGameView) // Remove the game view if it's already added
            }

            // Reinitialize game parameters
            score.text = "Score: 0"
            mGameView = GameView(this, this)

            mGameView.setBackgroundResource(R.drawable.asphaltroad3)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE
        }
    }

    override fun closeGame(mScore: Int) {
        score.text= "Score : $mScore "
        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
    }
}