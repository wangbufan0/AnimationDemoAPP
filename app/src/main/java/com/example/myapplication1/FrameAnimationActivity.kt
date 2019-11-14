package com.example.myapplication1

import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_frame_animation.*

class FrameAnimationActivity : AppCompatActivity() {

    companion object{
         fun launch(context: Context){
             val intent=Intent(context,FrameAnimationActivity::class.java)
             context.startActivity(intent)
         }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        iv.setImageResource(R.drawable.frame_animation_jd)
        val animationDrawable:AnimationDrawable= iv.drawable as AnimationDrawable
        animationDrawable.start()
    }
}
  