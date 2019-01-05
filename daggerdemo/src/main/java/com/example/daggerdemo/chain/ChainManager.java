package com.example.daggerdemo.chain;

import java.util.List;

public class ChainManager implements IBaseChain {

    private List<IBaseChain> iBaseChainList;

    private int index = 0;

    //集合管理-》自己符合就消费了

    //add(A).add(B)
    public ChainManager addChain(IBaseChain iBaseChain) {
        iBaseChainList.add(iBaseChain);
        return this;
    }

    @Override
    public void doSomeThing(String target, IBaseChain iBaseChain) {
        //index ++
        if (index == iBaseChainList.size()) return;
        //符合条件 就取出当前的链条
        IBaseChain currentChain = iBaseChainList.get(index);
        index++;
        //传递this 指的是ChainManager管理类
        currentChain.doSomeThing(target,this);
    }

}
