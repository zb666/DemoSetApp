package com.example.mechrevo.demosetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.example.mechrevo.demosetapp.utils.HeterotypicScreenUtils;

public class OtherACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //111
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        if (android.os.Build.VERSION.SDK_INT >= 28) {
//            WindowManager.LayoutParams lp = this.getWindow().getAttributes();
//            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
//            this.getWindow().setAttributes(lp);
//        }
//        //222
//        // 沉浸式布局
//        HeterotypicScreenUtils.openFullScreenModel(this);
//
//        //如果只需要
//
//        HeterotypicScreenUtils.getHeterotypicSize(this);
//
//        int statusBarHeight = HeterotypicScreenUtils.getStatusBarHeight(this);
//
//        Log.d("test",statusBarHeight+"");
        setContentView(R.layout.activity_other_activity);
    }
}
