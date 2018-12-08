package com.example.daggerdemo.daggerpc;

import com.example.daggerdemo.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = PresenterMoudle.class)
public interface IAComponent {
    void inject(MainActivity mainActivity);
}
