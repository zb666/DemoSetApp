package com.example.mechrevo.demosetapp

import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Query
import rx.Observable

interface IMethodInput<R> {
    fun testResult(str:String?,result: R)

    @FormUrlEncoded
    fun test():Call<String>

}