package com.example.daggerdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.DefaultSpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.daggerdemo.app.MyApp;
import com.example.daggerdemo.bean.PersonMultipleItem;
import com.example.daggerdemo.multiple.MultipleItemQuickAdapter;
import com.example.daggerdemo.singleinject.Presenter;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import org.w3c.dom.Node;

import javax.inject.Inject;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_CODE = 0x11;

    @Inject
    Presenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textview);
        textView.setOnClickListener(this);
        textView.setText(getPackageName());
        recyclerView = findViewById(R.id.recycleview);
        final List<PersonMultipleItem> multipleItemList = new ArrayList<>();

        addItem(multipleItemList);
        final MultipleItemQuickAdapter itemQuickAdapter = new MultipleItemQuickAdapter(multipleItemList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
               if (i==0){
                   //占权重的4/4 也就是整行
                   return 4;
               }else if (i==1){
                   //占权重的3/4,也就是屏幕3/4
                   return 3;
               }
               //其余的都只会占屏幕的1/4，空间不够的话就进行换行
               return 1;
            }
        });
        recyclerView.setAdapter(itemQuickAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        //但是瀑布流这种的话是没法使用这个属性的
        recyclerView.setHasFixedSize(true);

        itemQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                itemQuickAdapter.loadMoreComplete();
            }
        });

//        itemQuickAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
//                if (position % 3 == 0) {
//                    return 1;
//                } else if (position % 3 == 1) {
//                    return 2;
//                }
//                return 3;
//            }
//        });

//        itemQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                int itemCount = itemQuickAdapter.getItemCount();
//                if (itemCount >= 40) {
////                    addItem(multipleItemList);
//                    itemQuickAdapter.loadMoreEnd();
//                } else {
//                    addItem(multipleItemList);
//                    itemQuickAdapter.loadMoreComplete();
//                }
//            }
//        }, recyclerView);
    }

    private void addItem(List<PersonMultipleItem> multipleItemList) {
        for (int i = 0; i < 30; i++) {
            PersonMultipleItem personItem = new PersonMultipleItem(i % 2 == 0 ? PersonMultipleItem.TEXT : PersonMultipleItem.IMAGE);
            personItem.setContext(":x " + i);
            multipleItemList.add(personItem);
        }
    }

    @Override
    public void onClick(View v) {
//        try {
//            Socket socket = new Socket("http:restapi.com", 80);
//            //数据的输入流
//            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            //输出流
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//
//            new Thread() {
//                @Override
//                public void run() {
//                    //socket 只要遵循http的报文格式 做出请求和响应即可
//                    String line = null;
//                    try {
//                        while ((line = bufferedReader.readLine()) != null) {
//                            System.out.print("");
//                        }
//                    } catch (IOException ex) {
//
//                    }
//
//                }
//            }.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
