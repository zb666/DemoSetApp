package com.example.daggerdemo.singleinject;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = PresenterMoudle.class)
public interface IPresenterComponent {
    Presenter providerPresenter();
}
