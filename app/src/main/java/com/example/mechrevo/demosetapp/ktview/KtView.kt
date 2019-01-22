package com.example.mechrevo.demosetapp.ktview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.mechrevo.demosetapp.R

class KtView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    init {
        setBackgroundColor(Color.BLUE)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        Log.d("KtView", "height：$heightSize, width：$widthSize heightMode：$heightMode")
        //请注意自定义View 只能测得matchparent和固定大小的尺寸，但是无法得知wrap的尺寸大小
        //如果没有对wrap做特殊处理的话默认是天后才哦你个父布局的大小

        var resultWidth = 0
        var resultHeight = 0
        if (widthMode == MeasureSpec.EXACTLY) {
            //就是建议的宽高
            resultWidth = widthSize
            resultHeight = heightSize
            setMeasuredDimension(resultWidth, resultHeight)

        } else if (widthMode == MeasureSpec.AT_MOST) {
            var defaultSize = 200
            resultHeight = defaultSize
            resultWidth = defaultSize

            setMeasuredDimension(resultWidth, resultHeight)
        }


    }

}