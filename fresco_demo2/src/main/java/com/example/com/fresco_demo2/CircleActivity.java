package com.example.com.fresco_demo2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com.fresco_demo2.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.net.URL;

public class CircleActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sdv;
    private Button bt_fresco_circle;
    private GenericDraweeHierarchyBuilder builder;
    private Uri uri;
    private Button bt_fresco_corner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        //获取Id
        sdv = (SimpleDraweeView) findViewById(R.id.sdv);
        bt_fresco_corner = (Button) findViewById(R.id.bt_fresco_corner);
        bt_fresco_circle = (Button) findViewById(R.id.bt_fresco_circle);
        //点击事件
        bt_fresco_circle.setOnClickListener(this);
        bt_fresco_corner.setOnClickListener(this);

        builder = new GenericDraweeHierarchyBuilder(getResources());
        uri = Uri.parse("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1528253631&di=025f37354f6b9c23b84d125b2a3b65da&src=http://old.bz55.com/uploads/allimg/150210/139-150210134411-50.jpg");
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()) {
         case R.id.bt_fresco_circle: //圆形
             //设置形状
             RoundingParams params = RoundingParams.asCircle();
             //创建设置参数 把形状装入
             GenericDraweeHierarchy hierarchy = builder.setRoundingParams(params).build();
             //将参数设置给控件
             sdv.setHierarchy(hierarchy);
             //传入地址
             sdv.setImageURI(uri);
             break;
         case R.id.bt_fresco_corner:  //圆角
            //设置弧度
             RoundingParams radius = RoundingParams.fromCornersRadius(30f);
             GenericDraweeHierarchy hierarchy1 = builder.setRoundingParams(radius).build();
             sdv.setHierarchy(hierarchy1);
             sdv.setImageURI(uri);
             break;
     }
    }
}
