package com.example.mechrevo.demosetapp.douban

//@Poko
data class DouBanBean(var count: Int, var start: Int, var total: Int, var title: String, var subjects: List<Subject>?)

data class Subject(var title: String)