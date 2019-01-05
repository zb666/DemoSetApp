package com.example.mechrevo.demosetapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyLayoutManager extends LinearLayoutManager implements RecyclerView.OnChildAttachStateChangeListener {

    private int mDrift = 0;

    public MyLayoutManager(Context context) {
        super(context);
    }

    public MyLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        view.addOnChildAttachStateChangeListener(this);
    }

    //当Item添加进来的时候
    @Override
    public void onChildViewAttachedToWindow(@NonNull View view) {
        //播放视频的操作 但是不知道要播放的视频是上个还是下一个视频
        if (mDrift > 0) {
            //向上

        } else {

        }

    }

    //暂停播放的操作
    @Override
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        if (mDrift > 0) {
            //向上
            //播放或者不播放的操作
        }else {

        }
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        mDrift = dy;
        return super.scrollVerticallyBy(dy, recycler, state);
    }
}
