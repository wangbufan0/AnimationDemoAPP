package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.bt1->FrameAnimationActivity.launch(this)
            R.id.bt2->TweenedAnimationActivity.launch(this)
            R.id.bt3->PropertyAnimationActivity.launch(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
    }
}
