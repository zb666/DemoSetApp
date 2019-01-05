package com.example.daggerdemo.fac

import com.example.daggerdemo.Box

interface IFactory<T> {
    fun getBox(name:String): Box<T>
}