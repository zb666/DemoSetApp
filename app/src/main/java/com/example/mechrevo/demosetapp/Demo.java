package com.example.mechrevo.demosetapp;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    void test() {
        //协变 生产者
        List<? extends String> list = new ArrayList<>();
        //只能生产数据
        String s = list.get(0);
        //不能消费数据
//        list.add("")

        //逆变 消费者
        List<? super String> superList = new ArrayList<>();
        //只能消费数据
        superList.add("");
        //不能生产数据
        Object s1 = superList.get(0);

    }
}
