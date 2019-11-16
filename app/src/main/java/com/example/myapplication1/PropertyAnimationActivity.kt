package com.example.myapplication1

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_property_animation.*

class PropertyAnimationActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.bt_alpha->alphaAnimation!!.start()
            R.id.bt_rotate->rotateAnimation!!.start()
            R.id.bt_scale->scaleAnimation!!.start()
            R.id.bt_translate->translateAnimation!!.start()
            R.id.bt_set->setanimation!!.start()
            R.id.iv-> Toast.makeText(this,"图片被点击", Toast.LENGTH_SHORT).show()
            R.id.bt_point->{
                type++
                if (type==9)type=1
                pav.setInterpolatorType(type)
                pav.stopAnimation()
                pav.startAnimation()
            }
        }
    }
    private var type:Int=1
    companion object{
        fun launch(context: Context){
            val intent=Intent(context,PropertyAnimationActivity::class.java)
            context.startActivity(intent)
        }
    }


    private var alphaAnimation: ObjectAnimator?=null
    private var rotateAnimation: ObjectAnimator?=null
    private var scaleAnimation: ObjectAnimator?=null
    private var translateAnimation: ObjectAnimator?=null
    private var setanimation: AnimatorSet?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animation)


        alphaAnimation= ObjectAnimator.ofFloat(iv,"alpha",1f,0f,1f)
        alphaAnimation!!.duration = 3000

        rotateAnimation= ObjectAnimator.ofFloat(iv,"rotation",0f,360f)
        rotateAnimation!!.duration=3000

        scaleAnimation= ObjectAnimator.ofFloat(iv,"scaleX",1f,2f,1f)
        scaleAnimation!!.duration=3000


        translateAnimation= ObjectAnimator.ofFloat(iv,"translationX",0f,200f,0f)
        translateAnimation!!.duration=3000

        setanimation=AnimatorSet()
        setanimation!!.playTogether(alphaAnimation,rotateAnimation,scaleAnimation,translateAnimation)

        bt_alpha.setOnClickListener(this)
        bt_rotate.setOnClickListener(this)
        bt_scale.setOnClickListener(this)
        bt_translate.setOnClickListener(this)
        bt_set.setOnClickListener(this)
        bt_point.setOnClickListener(this)
        iv.setOnClickListener(this)

    }
}
