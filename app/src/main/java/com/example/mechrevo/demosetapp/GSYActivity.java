package com.example.mechrevo.demosetapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.mechrevo.demosetapp.douban.DouBanBean;
import com.example.mechrevo.demosetapp.douban.IDouBanApi;
import com.example.mechrevo.demosetapp.jetpackdemo.User;
import com.example.mechrevo.demosetapp.jetpackdemo.UserViewModel;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建LiveDtaa
 * 创建观察者Observer
 * 调用LiveData的observer方法(observe)方法将LiveData以及Observer建立起订阅的关系
 * 在合适的世纪(Active状态)发送set/post 发送数据通知观察者
 * state记录不同的状态 mActiveCount>0 表示处于活跃状态
 */
public class GSYActivity extends AppCompatActivity implements View.OnClickListener {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsy);

        //数据提供者 ViewMode
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        Observer<User> userObserver = new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user == null) return;
                //用来更新ui
                Log.d("User", user.toString());
            }
        };

        //进行观察者的注册操作
        MutableLiveData<User> userLiveData = userViewModel.getUserLiveData();
        userLiveData.observe(this, userObserver);


        findViewById(R.id.tv_send_msg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        User user = new User("周波",1);
        userViewModel.getUserLiveData().setValue(user);
    }
}
