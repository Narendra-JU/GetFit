package com.example.getfit

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewMainActivity.animation=AnimationUtils.loadAnimation(this,R.anim.item_animation_up_to_down)
        textView.animation=AnimationUtils.loadAnimation(this,R.anim.item_animation_up_to_down)


        mainscreen.setOnClickListener {
            startActivity(Intent(this,StopwatchActivity::class.java))

        }
    }
}