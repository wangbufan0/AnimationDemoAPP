package com.example.myapplication1

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

/**
 *
 * @ProjectName: My Application1
 * @Package: com.example.myapplication1
 * @ClassName: PointAnimView
 * @Description(java类作用描述):
 * @Author: wangbufan
 * @CreateDate: 2019/11/13 19:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/13 19:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class PointAnimView: View {

    companion object{
        public val RADIUS:Float=20f
    }


    var color:Int=Color.TRANSPARENT
        set(value) {
            field=value
            paint.color=field
        }

    private var radius:Float= RADIUS

    constructor(context: Context):super(context){
        init()

    }
    constructor(context: Context,attrs:AttributeSet):super(context,attrs){
        init()

    }
    constructor(context: Context,attrs:AttributeSet,defStyleAttr:Int):super(context,attrs,defStyleAttr){
        init()

    }


    private lateinit var paint:Paint
    private lateinit var linePaint: Paint


    fun init(){
        paint= Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color=Color.TRANSPARENT
        linePaint= Paint(Paint.ANTI_ALIAS_FLAG)
        linePaint.color=Color.BLACK
        linePaint.strokeWidth=5f
    }


    private var point:Point?=null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (point==null) {
            point = Point(RADIUS, RADIUS)
            drawCircle(canvas)
            startAnimation()
        }else{
            drawCircle(canvas)
        }

        drawLine(canvas)
    }

    private fun drawCircle(canvas: Canvas){
        canvas.drawCircle(point!!.x,point!!.y,radius,paint)
    }

    private fun drawLine(canvas: Canvas){
        canvas.drawLine(10f, (height/2).toFloat(), width.toFloat(), (height/2).toFloat(),linePaint)
        canvas.drawLine(10f, (height/2-150).toFloat(),10f, (height/2+150).toFloat(),linePaint)
       // canvas.drawPoint(point!!.x,point!!.y,linePaint)
    }

    private fun startAnimation(){
        val startP=Point(RADIUS, RADIUS)
        val endP=Point(width- RADIUS,height- RADIUS)
        val valueAnimator=ValueAnimator.ofObject(PointSinEvaluator(),startP,endP)
        valueAnimator.repeatCount=-1
        valueAnimator.repeatMode=ValueAnimator.REVERSE
        valueAnimator.addUpdateListener { animation ->
            point= animation.animatedValue as Point
            postInvalidate()
        }

        val animaColor=ObjectAnimator.ofObject(this,"color",ArgbEvaluator(),Color.GREEN,
                Color.YELLOW,Color.BLUE,Color.WHITE,Color.RED)
        animaColor.repeatCount=-1
        animaColor.repeatMode=ValueAnimator.REVERSE


        val animScale=ValueAnimator.ofFloat(20f,80f,60f,10f,35f,55f,10f)
        animScale.repeatCount=-1
        animScale.duration=5000
        animScale.addUpdateListener{
            radius= it.animatedValue as Float
        }

        val animSet=AnimatorSet()
        animSet.play(valueAnimator).with(animaColor).with(animScale)
        animSet.duration=5000
        animSet.interpolator=LinearInterpolator()
        animSet.start()
    }


}