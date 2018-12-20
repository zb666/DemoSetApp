package com.example.daggerdemo.kt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.daggerdemo.R

class OkHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)
        findViewById<TextView>(R.id.textview).setOnClickListener {
            testRequest()
        }


    }

    private fun testRequest() {

    }
}