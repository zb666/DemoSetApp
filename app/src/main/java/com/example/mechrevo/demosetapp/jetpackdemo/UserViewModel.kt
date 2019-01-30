package com.example.mechrevo.demosetapp.jetpackdemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val mutableLiveData by lazy {
        MutableLiveData<User>()
    }

    fun getUserLiveData(): MutableLiveData<User> {
        return mutableLiveData
    }


}
