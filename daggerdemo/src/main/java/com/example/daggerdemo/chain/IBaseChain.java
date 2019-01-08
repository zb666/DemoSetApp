package com.example.daggerdemo.chain;

public interface IBaseChain {
    //需要匹配的数据 你搞不定了 抛给别人
    void doSomeThing(String target, IBaseChain iBaseChain);
}
