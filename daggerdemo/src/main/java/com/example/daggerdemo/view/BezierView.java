package com.example.daggerdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import okhttp3.*;

import java.io.IOException;

public class BezierView extends View {

    private Paint mPaint;
    private Path mPath;

    private static final String URL = "https://www.baidu.com/";

    public BezierView(Context context) {
        this(context,null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder().url(URL).build();
                Call call = okHttpClient.newCall(request);

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("Bob",response.toString());
                    }
                });
                break;
//                mPath.quadTo();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         canvas.drawPath(mPath,mPaint);
    }
}
