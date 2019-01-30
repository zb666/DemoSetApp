package com.example.daggerdemo;

import android.content.Context;


import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import org.jetbrains.annotations.TestOnly;


import java.util.concurrent.TimeUnit;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {

    public static void main(String[] args){
        test();
    }

    @TestOnly
    public static void test() {
        Observable<String> net = Observable.just("net");
        Observable<String> disk = Observable.just("disk");

        Observable.concat(disk, net)
                .firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

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
