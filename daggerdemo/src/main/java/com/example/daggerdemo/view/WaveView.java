package com.example.daggerdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

//向左移动一个波长的距离
//该波长可以作为偏移量控制offset来控制波浪的走动
//起始点就是我们移动一个波长的距离 以-3/4,-1/2,-1/4,0为贝塞尔曲线的控制点控制波浪
//用offset的偏移量控制波形的滚动
public class WaveView extends View implements View.OnClickListener {

    private Paint mPaintBezier;
    private int mWaveLength;
    private int mScreenHeight;
    private int mScreenWidth;
    private Path mWavePath;
    private int mWaveCount;
    private int mOffset = 0;
    private int mCenterY;
    private ValueAnimator mOffsetAnim;

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaintBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBezier.setColor(Color.BLUE);
        mPaintBezier.setStrokeWidth(10);
        mPaintBezier.setStyle(Paint.Style.FILL_AND_STROKE);

        mWavePath = new Path();

        mWaveLength = 720;

        setOnClickListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mScreenHeight = h;
        mScreenWidth = w;

        //mWaveCount = (int) Math.round(mScreenWidth / mWaveLength + 1.5);
        //向左移动1.5个波长
        mWaveCount = (int) Math.round(mScreenWidth / mWaveLength + 1.5);

        mCenterY = mScreenHeight / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWavePath.reset();
        //移动一个波形
        mWavePath.moveTo(-mWaveLength + mOffset, mCenterY);
        //改变所有波浪的波动
        for (int i = 0; i < mWaveCount; i++) {
            //每个点都需要动起来  并且需要进行偏移
            mWavePath.quadTo(
                    -mWaveLength * 3 / 4 + i * mWaveLength + mOffset,
                    mCenterY - 100,
                    -mWaveLength / 2 + i * mWaveLength + mOffset,
                    mCenterY);

            mWavePath.quadTo(
                    -mWaveLength / 4 + i * mWaveLength + mOffset,
                    mCenterY + 100,
                    i * mWaveLength + mOffset,
                    mCenterY);
        }
        mWavePath.lineTo(mScreenWidth, mScreenHeight);
        mWavePath.lineTo(0, mScreenHeight);
        mWavePath.close();
        canvas.drawPath(mWavePath, mPaintBezier);
    }


    @Override
    public void onClick(View v) {
        if (mOffsetAnim == null) {
            mOffsetAnim = ValueAnimator.ofInt(0, mWaveLength);
            mOffsetAnim.setDuration(1000);
            mOffsetAnim.setRepeatMode(ValueAnimator.RESTART);
            mOffsetAnim.setRepeatCount(ValueAnimator.INFINITE);
            mOffsetAnim.setInterpolator(new LinearInterpolator());
            mOffsetAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mOffset = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            if (!mOffsetAnim.isRunning()) {
                mOffsetAnim.start();
            }
        }
    }
}
