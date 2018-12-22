package com.example.daggerdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.nio.file.Path;

public class SignView extends View {

    private Paint mPaintBezier;
    private android.graphics.Path mPath;
    private int mStartX;
    private int mStartY;
    private android.graphics.Path mMeasurePath;
    private android.graphics.Path dst;

    public SignView(Context context) {
        this(context, null);
    }

    public SignView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSign();
    }

    private void initSign() {
        mPaintBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBezier.setStrokeWidth(8);
        mPaintBezier.setStyle(Paint.Style.STROKE);
        mPaintBezier.setColor(Color.GREEN);
        mPath = new android.graphics.Path();

        mMeasurePath = new android.graphics.Path();
        mMeasurePath.addRect(-50,-50,50,50, android.graphics.Path.Direction.CW);
        //构造出PathMeasure路径
        PathMeasure pathMeasure = new PathMeasure(mMeasurePath,false);
        //截取路径
        dst =  new android.graphics.Path();
        //截取该路径0-150 然后放置到dst路径之下
        pathMeasure.getSegment(0,150,dst,true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mStartX = (int) event.getX();
                mStartY = (int) event.getY();
                mPath.moveTo(mStartX, mStartY);
                break;
            case MotionEvent.ACTION_MOVE:
                int mNextBezierX = (int) event.getX();
                int mNextBezierY = (int) event.getY();
                int mQuadX = (mNextBezierX + mStartX) / 2;
                int mQuadY = (mNextBezierY + mStartY) / 2;
                mPath.quadTo(mStartX, mStartY, mQuadX, mQuadY);
                postInvalidate();
                mStartX = mNextBezierX;
                mStartY = mNextBezierY;
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaintBezier);
        canvas.drawPath(dst,mPaintBezier);
    }

    /**
     * 当前屏幕的大小
     * @param w 宽度
     * @param h 高度
     * @param oldw 旧的宽度
     * @param oldh 旧的高度
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("BobV","onSizeChanged");
    }
}
