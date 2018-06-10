package com.example.com.fresco_demo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private String path = "http://imgsrc.baidu.com/imgad/pic/item/9d82d158ccbf6c8154bdd5ccb63eb13533fa4008.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = Uri.parse("path");
        //初始化控件
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        //加载图片
        draweeView.setImageURI(uri);
    }
}
