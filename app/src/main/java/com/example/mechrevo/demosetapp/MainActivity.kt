package com.example.mechrevo.demosetapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.DisplayCutout
import android.widget.Toast
import com.example.mechrevo.demosetapp.dagger.A
import com.example.mechrevo.demosetapp.dagger.AMoudle
import com.example.mechrevo.demosetapp.inter_in_out.IArray
import com.example.mechrevo.demosetapp.inter_in_out.ITestKotlin
import com.example.mechrevo.demosetapp.inter_in_out.InTest
import com.example.mechrevo.demosetapp.ktview.KtView
import com.example.mechrevo.demosetapp.sealeddemo.Expr
import com.just.library.LogUtils
import com.squareup.leakcanary.LeakCanary
import dagger.internal.DaggerCollections
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ITestKotlin, IMethodInput<String> {
    override fun test(): Call<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun testResult(str: String?, result: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


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

        var bundle = Bundle()
        bundle.putString("key", "value")

        var intent = Intent()
        intent.setClass(this, GSYActivity::class.java)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }


    fun sum(a: Int, b: Int): String {
        return (a + b).toString()
    }

    inner class Inner {
        fun too() = ""
    }

    fun testSealed(a: Int) {
        var ktView = Expr.Const(null)

        when (a) {
            in 0..2 -> print("111")
            3 -> print("222")
            else -> print("other")
        }

    }


}
