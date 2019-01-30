package com.example.hhh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, DemoActivity.class));

        test();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("onNewIntent", "onNewIntent");
    }

    public void test() {
        Observable<String> net = Observable.just("net");
        Observable<String> disk = Observable.just("disk");

        Observable.concat(disk, net)
                .firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("Consumer", s);
                    }
                });

        Observable.interval(1000, 1000, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("interval", aLong + "");
                    }
                });
    }
}
