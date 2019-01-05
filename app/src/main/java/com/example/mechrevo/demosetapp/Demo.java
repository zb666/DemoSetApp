package com.example.mechrevo.demosetapp;

import android.support.annotation.Nullable;
import com.example.mechrevo.demosetapp.rt.A;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Demo extends Converter.Factory{

    void test() {
        //协变 生产者 extends
        List<? extends String> list = new ArrayList<>();
        //只能生产数据
        String s = list.get(0);
        //不能消费数据
//        list.add("")

        //逆变 super
        List<? super String> superList = new ArrayList<>();
        //只能消费数据
        superList.add("");
        //不能生产数据
        Object s1 = superList.get(0);

    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit) {
        type.getClass();
        Class<? extends Annotation> typeAnno = annotations[0].annotationType();

        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
