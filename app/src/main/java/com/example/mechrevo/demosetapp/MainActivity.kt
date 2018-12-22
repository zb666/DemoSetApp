package com.example.mechrevo.demosetapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mechrevo.demosetapp.dagger.A
import com.example.mechrevo.demosetapp.dagger.AMoudle
import com.example.mechrevo.demosetapp.inter_in_out.IArray
import com.example.mechrevo.demosetapp.inter_in_out.ITestKotlin
import com.example.mechrevo.demosetapp.inter_in_out.InTest
import com.just.library.LogUtils
import dagger.internal.DaggerCollections
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ITestKotlin {

    @Inject
    val aInject: A? = null

    override fun drink() {
        LogPrintUtils.showLog("drink")
    }

    companion object {
        val str = "静态方法"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun sum(a: Int, b: Int): String {
        return (a + b).toString()
    }

    inner class Inner {
        fun too() = ""
    }


}
