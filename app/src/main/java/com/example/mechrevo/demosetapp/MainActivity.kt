package com.example.mechrevo.demosetapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mechrevo.demosetapp.dagger.AMoudle
import com.example.mechrevo.demosetapp.inter_in_out.IArray
import com.example.mechrevo.demosetapp.inter_in_out.ITestKotlin
import com.example.mechrevo.demosetapp.inter_in_out.InTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ITestKotlin {

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
        textview?.apply {
            text = "result: ${sum(1, 2)}"
        }
        println("a = $str")

        val a = 1
        val b = 2

        val resultOfCompare = if (a > b) a else b

        val arrayList = arrayOf("a", "b", "c")

        textview.setOnClickListener {
            for ((index, e) in arrayList.withIndex()) {
                println(e + " " + index)
            }

            for ((index, e) in arrayList.withIndex()) {
                LogPrintUtils.showLog(e + index)
            }

            for (element in arrayList) {
                drink()
            }
            //kotlin泛型推导
            val box = Box("构造方法")
            LogPrintUtils.showLog(box.value)

            //extends 对应形变 covariant 生产者  对应out(形变)
            //super 对应逆变性 contravariance 消费者 对应in(逆变）
            val arrayList1 = arrayList

            var inTest = InTest()


            val too = Inner().too()

        }

        val moudle = AMoudle()


    }


    fun sum(a: Int, b: Int): String {
        return (a + b).toString()
    }

    inner class Inner {
        fun too() = ""
    }


}
