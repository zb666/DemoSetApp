package com.example.mechrevo.demosetapp.inter_in_out

//生产者 对于数据 可以从它里面获取
interface IArray<in T> {
    operator fun compareTo(other:T):Int
}