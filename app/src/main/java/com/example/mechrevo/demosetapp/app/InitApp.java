package com.example.mechrevo.demosetapp.app;

import android.app.Application;
import com.github.moduth.blockcanary.BlockCanary;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class InitApp extends Application {

    private List<String>  list = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Class<? extends List> tClass = list.getClass();

        Type superclass = tClass.getGenericSuperclass();
        if (superclass instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) superclass).getActualTypeArguments();
            for (Type temp : types) {
                if (temp instanceof Class){
                    Class tempClass = (Class) temp;

                }else if (temp instanceof ParameterizedType){
                    Type rawType = ((ParameterizedType)temp).getRawType();
                }
            }
        }

        BlockCanary.install(this, new AppBlockContenxt() ).start();
    }
}
