package com.example.mechrevo.demosetapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
