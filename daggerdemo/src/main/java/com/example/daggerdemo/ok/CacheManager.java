package com.example.daggerdemo.ok;

import android.util.SparseArray;
import butterknife.ButterKnife;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CacheManager {


    HashMap<String, Object> mHashMap = new HashMap<>();

    public Class getCache(Class tClass) {
        if (tClass != null) {
            String name = tClass.getName();
            if (mHashMap.get(name) == null) {
                Class<? extends Class> aClass = tClass.getClass();
                mHashMap.put(name, tClass);
                return aClass;
            }
            return tClass.getClass();
        }
        return null;
    }

    public void clearCache(Class<?> tClass) {
        if (mHashMap.containsKey(tClass.getName())) {
            mHashMap.remove(tClass.getName());
        }
    }

    public void clearAllCache(Class<?> tClass) {
        Set<Map.Entry<String, Object>> entrySet = mHashMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            mHashMap.remove(entry.getKey());
        }
    }

}
