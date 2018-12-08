package com.example.mechrevo.demosetapp.dagger

import dagger.Component
import javax.inject.Singleton

//modules = {MainModule.class} jvm的注解会在这里找寻到需要注入的对象
@Singleton
@Component(modules = [AMoudle::class])
interface IMainComponent {
    //这里提供inject注入 这里不具备多态的功能
    fun injectA(a: A)
}