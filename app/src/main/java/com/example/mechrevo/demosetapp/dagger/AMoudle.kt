package com.example.mechrevo.demosetapp.dagger

import android.widget.Toast
import dagger.Module
import dagger.Provides

//A的提供者
@Module
class AMoudle {

    //kotlin 调用 kotlin的时候没有问题 但是java调用kotlin的时候就会存在一系列的问题
    @JvmOverloads
    fun testF(a: String, b: Int = 0, duration: Int = Toast.LENGTH_SHORT) {
    }

    companion object {
        @JvmStatic
        fun test(){

        }
    }

    @Provides
    fun providerA(): A {
        return A()
    }

}