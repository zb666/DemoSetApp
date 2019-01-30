package com.example.mechrevo.demosetapp.rxplugin;

import io.reactivex.ObservableOnSubscribe;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Observers;
import rx.schedulers.Schedulers;

import java.util.function.Consumer;

public class RxCall {
    void test() {

        Observable<String> netWork = Observable.just("网络请求的数据");

        Observable<String> diskWork = Observable.just("磁盘获取到的数据");

        Observable<String> memoryDisk = Observable.just("内存获取到的数据");

        Observable.concat(memoryDisk, diskWork, netWork)
                .takeFirst(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return null;
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

}
