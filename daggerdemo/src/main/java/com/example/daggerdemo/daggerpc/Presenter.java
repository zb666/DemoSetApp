package com.example.daggerdemo.daggerpc;

public class Presenter implements IPFunction{
    @Override
    public String getStr() {
        return getClass().getSimpleName();
    }
}
