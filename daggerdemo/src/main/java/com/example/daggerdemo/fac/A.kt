package com.example.daggerdemo.fac

import com.example.daggerdemo.Box

class A : IFactory<String> {
    init {
        var str = "str"
    }

    override fun getBox(name: String): Box<String> {
        var box = Box("")

        box.let {
            box.value

        }
        return box
    }
}