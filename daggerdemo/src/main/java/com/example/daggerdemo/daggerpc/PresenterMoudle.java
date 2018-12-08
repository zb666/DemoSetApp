package com.example.daggerdemo.daggerpc;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PresenterMoudle {

    //单例 这里的单例要和iComponent里面成对出现
    @Singleton
    @Provides
    Presenter getP(){
        return new Presenter();
    }
}
