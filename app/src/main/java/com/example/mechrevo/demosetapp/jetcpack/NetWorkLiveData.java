package com.example.mechrevo.demosetapp.jetcpack;

import android.arch.lifecycle.LiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.lang.ref.WeakReference;

public class NetWorkLiveData extends LiveData<Integer> {

    private static NetWorkLiveData sNetWorkLiveData;

    private WeakReference<Context> mContextWeakReference;



    private class NetworkChangeReceiver extends BroadcastReceiver {

        public final int wifi = 2, mobile = 1, none = 0;
        public int oldState = none;

        /**
         * 触发网络状态监听回调
         *
         * @param nowStatus 当前网络状态
         */
        private void setChange(int nowStatus) {
            oldState = nowStatus;
            sNetWorkLiveData.setValue(oldState);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {
                Log.i("通知", "网络不可以用");
                setChange(none);
            } else if (mobNetInfo.isConnected()) {
                Log.i("通知", "仅移动网络可用");
                setChange(mobile);
            } else if (wifiNetInfo.isConnected()) {
                Log.i("通知", "Wifi网络可用");
                setChange(wifi);
            }
        }
    }

}
