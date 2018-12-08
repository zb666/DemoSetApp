package com.example.mechrevo.demosetapp.dagger

import dagger.Component

//modules = {MainModule.class} jvm的注解会在这里找寻到需要注入的对象
@Component(modules = arrayOf(AMoudle::class))
interface IMainComponent {
    //这里提供inject注入
    fun injectA(a: A)
}