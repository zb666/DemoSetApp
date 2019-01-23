package com.example.mechrevo.demosetapp.douban

import com.google.gson.annotations.SerializedName

@Poko
data class DouBanBean(var count:Int, var start:Int, var total:Int, var title:String)