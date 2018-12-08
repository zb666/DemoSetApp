package com.example.daggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.daggerdemo.daggerpc.DaggerIAComponent;
import com.example.daggerdemo.daggerpc.Presenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Presenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerIAComponent.create().inject(this);

        TextView textView =  findViewById(R.id.textview);
        textView.setText(iPresenter.getStr());
    }
}
