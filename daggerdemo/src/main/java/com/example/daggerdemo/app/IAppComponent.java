package com.example.daggerdemo.app;

import com.example.daggerdemo.ActivityScope;
import com.example.daggerdemo.activity.MainActivity;
import com.example.daggerdemo.singleinject.IPresenterComponent;
import dagger.Component;

@ActivityScope
@Component(dependencies = IPresenterComponent.class)
public interface IAppComponent {
    void injectMainActivity(MainActivity mainActivity);
}
