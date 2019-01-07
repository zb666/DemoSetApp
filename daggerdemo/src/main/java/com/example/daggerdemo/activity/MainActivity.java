package com.example.daggerdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.daggerdemo.R;
import com.example.daggerdemo.app.MyApp;
import com.example.daggerdemo.ok.CacheManager;
import com.example.daggerdemo.singleinject.Presenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import okhttp3.internal.connection.RealConnection;

import javax.inject.Inject;
import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0x11;

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tvJump = findViewById(R.id.tvJump);
        tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),OkActivity.class));
                finish();
            }
        });



        final TextView textView = findViewById(R.id.textview);

        CacheManager cacheManager = new CacheManager();
        cacheManager.getCache(textView.getClass());

        //全局单例 因为PresenterMoudle由我们的app执行 但是app又是单例的
        //这样的话就能解决这个单例 只会在只用的类里面是单例的尴尬
        ((MyApp) getApplication()).getAppComponent()
                .injectMainActivity(this);
        final ImageView imageView = findViewById(R.id.image);

        //所有的单例 都会由application提供
//        ((MyApp)getApplication()).getAppComponent() 而且这里的注入主需要在app里面完成编译
        //不需要inject之后 在执行build操作
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
//                startActivityForResult(intent, REQUEST_CODE);
                String textContent = "您好啊";
                if (TextUtils.isEmpty(textContent)) {
//                    Toast.makeText(ThreeActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bitmap image = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round));
                imageView.setImageBitmap(image);
            }
        });
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }




        Deque<RealConnection> connections = new ArrayDeque<>();

    }

    public void switchToL(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //do something
        } else {
            ///Toast.makeText(VectorDemo.this, "当前系统不支持L Plus", Toast.LENGTH_LONG).show();
        }
    }

}
