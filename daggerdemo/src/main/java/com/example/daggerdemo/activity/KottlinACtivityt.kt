package com.example.daggerdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerdemo.R
import com.example.daggerdemo.bean.PersonMultipleItem

class KottlinACtivityt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kottlin_activityt)

        PersonMultipleItem.IMAGE

        var personMultipleItem = PersonMultipleItem(1)
        personMultipleItem.context

    }
}
