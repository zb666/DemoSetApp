package com.example.daggerdemo.app;

import android.app.Application;
import com.example.daggerdemo.singleinject.DaggerIPresenterComponent;

public class MyApp extends Application {

    private IAppComponent iAppComponent;

    //dependcies 由component执行代理 -》然后再由PresenterMoudle执行代理
    @Override
    public void onCreate() {
        super.onCreate();
        iAppComponent = DaggerIAppComponent.builder()
                .iPresenterComponent(DaggerIPresenterComponent.create())
                .build();
    }

    public IAppComponent getAppComponent() {
        return iAppComponent;
    }

}
