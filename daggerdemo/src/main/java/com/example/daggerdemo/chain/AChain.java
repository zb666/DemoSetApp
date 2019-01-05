package com.example.daggerdemo.chain;

public class AChain implements IBaseChain {
    @Override
    public void doSomeThing(String target, IBaseChain iBaseChain) {
        if ("a".equals(target)) {
           //do A
            return;
        }
        //ChainManager
        iBaseChain.doSomeThing(target, iBaseChain);
    }
}
