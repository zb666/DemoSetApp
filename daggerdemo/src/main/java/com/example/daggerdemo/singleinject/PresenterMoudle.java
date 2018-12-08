package com.example.daggerdemo.singleinject;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PresenterMoudle {

    @Singleton
    @Provides
    Presenter getPresenter() {
        return new Presenter();
    }
}
