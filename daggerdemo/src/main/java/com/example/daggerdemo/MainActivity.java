package com.example.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.daggerdemo.app.MyApp;
import com.example.daggerdemo.singleinject.Presenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView = findViewById(R.id.textview);

        //全局单例 因为PresenterMoudle由我们的app执行 但是app又是单例的
        //这样的话就能解决这个单例 只会在只用的类里面是单例的尴尬
        ((MyApp) getApplication()).getAppComponent()
                .injectMainActivity(this);

        //所有的单例 都会由application提供
//        ((MyApp)getApplication()).getAppComponent() 而且这里的注入主需要在app里面完成编译
        //不需要inject之后 在执行build操作
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(presenter.getStr());
            }
        });

    }
}
