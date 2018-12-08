package com.example.mechrevo.demosetapp.inter_in_out

class InTest : IArray<String> {
    override fun compareTo(other: String): Int {
        return 1
    }

    fun <T> singleTonTest(item: T): T {
        return item
    }
}