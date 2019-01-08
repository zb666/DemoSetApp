package com.example.mechrevo.demosetapp;

import android.support.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface Converter<F,T> {

    T convert(F value) throws IOException;

    abstract class Factory{
        public @Nullable
        Converter<ResponseBody, ?> responseBodyConverter(
                Type type,
                Annotation[] annotations,
                Retrofit retrofit) {
            return null;
        }

    }

}
