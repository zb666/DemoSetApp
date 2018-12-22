package com.example.daggerdemo.app;

import com.example.daggerdemo.ActivityScope;
import com.example.daggerdemo.MainActivity;
import com.example.daggerdemo.singleinject.IPresenterComponent;
import com.example.daggerdemo.singleinject.Presenter;
import com.example.daggerdemo.singleinject.PresenterMoudle;
import dagger.Component;

import javax.inject.Singleton;

@ActivityScope
@Component(dependencies = IPresenterComponent.class)
public interface IAppComponent {
    void injectMainActivity(MainActivity mainActivity);
}
