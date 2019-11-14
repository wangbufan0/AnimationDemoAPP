package com.example.myapplication1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tweened_animation.*

class TweenedAnimationActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onClick(v: View) {
        when(v.id){
            R.id.bt_alpha->iv.startAnimation(alphaAnimation)
            R.id.bt_rotate->iv.startAnimation(rotateAnimation)
            R.id.bt_scale->iv.startAnimation(scaleAnimation)
            R.id.bt_translate->iv.startAnimation(translateAnimation)
            R.id.bt_set->iv.startAnimation(setanimation)
            R.id.iv-> Toast.makeText(this,"图片被点击",Toast.LENGTH_SHORT).show()
        }
    }

    companion object{
        fun launch(context: Context){
            val intent=Intent(context,TweenedAnimationActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var alphaAnimation:Animation?=null
    private var rotateAnimation:Animation?=null
    private var scaleAnimation:Animation?=null
    private var translateAnimation:Animation?=null
    private var setanimation:Animation?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweened_animation)
        bt_alpha.setOnClickListener(this)
        bt_rotate.setOnClickListener(this)
        bt_scale.setOnClickListener(this)
        bt_translate.setOnClickListener(this)
        bt_set.setOnClickListener(this)
        iv.setOnClickListener(this)
        alphaAnimation=AnimationUtils.loadAnimation(this,R.anim.tweened_alpha_anim)
        rotateAnimation=AnimationUtils.loadAnimation(this,R.anim.tweened_rotate_anim)
        scaleAnimation=AnimationUtils.loadAnimation(this,R.anim.tweened_scale_anim)
        translateAnimation=AnimationUtils.loadAnimation(this,R.anim.tweened_translate_anim)
        setanimation=AnimationUtils.loadAnimation(this,R.anim.tweened_set_anim)
    }
}
