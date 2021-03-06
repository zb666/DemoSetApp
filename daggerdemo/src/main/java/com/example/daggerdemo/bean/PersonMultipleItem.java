package com.example.daggerdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;

public class PersonMultipleItem implements MultiItemEntity {
    //every itemtype
    @JvmField
    public static final int TEXT = 0x11;

    public static final int IMAGE = 0x12;

    private int itemType;

    public PersonMultipleItem(int itemType) {
        this.itemType = itemType;
    }

    private String context;

    @JvmStatic
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public int getItemType() {
        return itemType ;
    }
}
