package com.example.mechrevo.demosetapp

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.github.moduth.blockcanary.BlockCanary
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.just.library.LogUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DemoActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DemoActivity_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val i = 1 shl 8
        Log.d(TAG, "start \n test$i")

        val params = window.attributes
        val lp = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER
        window.setGravity(lp)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

    }

}
