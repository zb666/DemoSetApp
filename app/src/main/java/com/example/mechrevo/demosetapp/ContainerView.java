package com.example.mechrevo.demosetapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class ContainerView extends ViewGroup {
    public ContainerView(Context context) {
        super(context);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //让子View进行自我测量，根据子view给出的尺寸得出子view的位置，并且进行保存
        int childCount = getChildCount();
        int height = 0;
        int width = 0;
        for (int i = 0; i < childCount; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);


        }


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
