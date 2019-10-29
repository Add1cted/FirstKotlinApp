package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import android.R.attr.start
import android.animation.ArgbEvaluator
import android.view.animation.Animation
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import kotlinx.android.synthetic.main.activity_display_message.*


class DisplayMessageActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        val anim = ObjectAnimator.ofInt(
            view, "backgroundColor", Color.BLACK, Color.RED,
            Color.BLACK
        )
        anim.duration = 500
        anim.setEvaluator(ArgbEvaluator())
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        anim.start()

    }
}
