package com.example.mechrevo.demosetapp.adapter

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class MyAdapterFactory : CallAdapter.Factory() {
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        return null
    }

}