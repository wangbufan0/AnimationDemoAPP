package com.example.myapplication1

import android.animation.TypeEvaluator
import kotlin.math.sin

/**
 *
 * @ProjectName: My Application1
 * @Package: com.example.myapplication1
 * @ClassName: PointSinEvaluator
 * @Description(java类作用描述):
 * @Author: wangbufan
 * @CreateDate: 2019/11/13 23:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/11/13 23:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class PointSinEvaluator:TypeEvaluator<Point> {
    override fun evaluate(fraction: Float, startValue: Point, endValue: Point): Point {

        val x=startValue.x+fraction*(endValue.x-startValue.x)
        val y:Float= (sin(x*Math.PI/180) *100).toFloat()+endValue.y/2
        return Point(x,y)
    }
}