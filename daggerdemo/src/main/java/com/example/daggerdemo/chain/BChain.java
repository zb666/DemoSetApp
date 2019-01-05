package com.example.daggerdemo.chain;

public class BChain implements IBaseChain {
    @Override
    public void doSomeThing(String target, IBaseChain iBaseChain) {
        if ("b".equals(target)) {
            //do show
            //100行
            return;
        }
        //ChainManager
        iBaseChain.doSomeThing(target, iBaseChain);
    }
}
