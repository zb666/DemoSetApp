package com.example.mechrevo.demosetapp

import android.util.Log

class LogPrintUtils {
    companion object {
        fun showLog(test: String = "ddd") {
            Log.d("Bob", test)
        }
    }
}