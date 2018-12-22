package com.example.daggerdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SecondBezierView extends View {

    private Paint mPaintBezier;
    private Paint mPaintFlag;
    private Paint mPaintFlagText;
    private int mX;
    private int mY;
    private Path mPath;
    private int mStartX;
    private int mStartY;

    public SecondBezierView(Context context) {
        this(context,null);
    }

    public SecondBezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SecondBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mStartX = w/4;
        mStartY = h/2-200;
    }

    private void init() {
        mPaintBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBezier.setStrokeWidth(8);
        mPaintBezier.setStyle(Paint.Style.STROKE);

        mPaintFlag = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFlag.setStrokeWidth(3);
        mPaintFlag.setStyle(Paint.Style.STROKE);

        mPaintFlagText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFlagText.setStyle(Paint.Style.STROKE);
        mPaintFlagText.setTextSize(20);

        mPath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            mX = (int) event.getX();
            mY = (int) event.getY();
            invalidate();
        }
        return true;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPath.moveTo(200,100);
        mPath.quadTo(mStartX,mStartY,mX,mY);
        canvas.drawPath(mPath,mPaintBezier);
    }
}
