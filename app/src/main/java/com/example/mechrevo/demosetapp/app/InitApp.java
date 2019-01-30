package com.example.mechrevo.demosetapp.app;

import android.app.Application;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import com.didichuxing.doraemonkit.DoraemonKit;
import com.didichuxing.doraemonkit.kit.webdoor.WebDoorManager;
import com.github.moduth.blockcanary.BlockCanary;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class InitApp extends MultiDexApplication {

    private List<String> list = new ArrayList<>();

    private static final String TAG = "DoraemonKit";

    @Override
    public void onCreate() {
        super.onCreate();
        Class<? extends List> tClass = list.getClass();

        Type superclass = tClass.getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) superclass).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class) {
                    Class tempClass = (Class) temp;

                } else if (temp instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) temp).getRawType();
                }
            }
        }

        BlockCanary.install(this, new AppBlockContenxt()).start();

        DoraemonKit.install(this);
// H5任意门功能需要，非必须
        DoraemonKit.setWebDoorCallback(new WebDoorManager.WebDoorCallback() {
            @Override
            public void overrideUrlLoading(String s) {
                // 使用自己的H5容器打开这个链接
                Log.d(TAG,s);
            }
        });

    }

}
