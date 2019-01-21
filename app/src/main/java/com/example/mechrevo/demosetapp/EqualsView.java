package com.example.mechrevo.demosetapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class EqualsView extends ImageView {
    public EqualsView(Context context) {
        super(context);
    }

    public EqualsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EqualsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        setImageResource(R.drawable.block_canary_icon);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int finalSize = measuredWidth > measuredHeight ? measuredWidth : measuredHeight;
        setMeasuredDimension(finalSize,finalSize);
    }
}
