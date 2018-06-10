package com.example.com.fresco_demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_fresco_circleAndCorner;
    private Button bt_fresco_spimg;
    private Button bt_fresco_gif;
    private Button bt_fresco_multi;
    /**
     * 图片的不同裁剪
     */
    private Button mBtFrescoCrop;
    /**
     * 渐进式展示图片
     */
    private Button mBtFrescoJpeg;
    /**
     * 图片加载监听
     */
    private Button mBtFrescoListener;
    /**
     * 图片缩放和旋转
     */
    private Button mBtFrescoResize;
    /**
     * 修改图片
     */
    private Button mBtFrescoModifyImg;
    /**
     * 动态展示图片
     */
    private Button mBtFrescoAutoSizeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bt_fresco_circleAndCorner.setOnClickListener(this);
        bt_fresco_spimg.setOnClickListener(this);
        bt_fresco_gif.setOnClickListener(this);
        bt_fresco_multi.setOnClickListener(this);
    }

    private void initView() {
        bt_fresco_circleAndCorner = (Button) findViewById(R.id.bt_fresco_circleAndCorner);
        bt_fresco_spimg = (Button) findViewById(R.id.bt_fresco_spimg);
        bt_fresco_gif = (Button) findViewById(R.id.bt_fresco_gif);
        bt_fresco_multi = (Button) findViewById(R.id.bt_fresco_multi);
        mBtFrescoCrop = (Button) findViewById(R.id.bt_fresco_crop);
        mBtFrescoCrop.setOnClickListener(this);
        mBtFrescoJpeg = (Button) findViewById(R.id.bt_fresco_jpeg);
        mBtFrescoJpeg.setOnClickListener(this);
        mBtFrescoListener = (Button) findViewById(R.id.bt_fresco_listener);
        mBtFrescoListener.setOnClickListener(this);
        mBtFrescoResize = (Button) findViewById(R.id.bt_fresco_resize);
        mBtFrescoResize.setOnClickListener(this);
        mBtFrescoModifyImg = (Button) findViewById(R.id.bt_fresco_modifyImg);
        mBtFrescoModifyImg.setOnClickListener(this);
        mBtFrescoAutoSizeImg = (Button) findViewById(R.id.bt_fresco_autoSizeImg);
        mBtFrescoAutoSizeImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_circleAndCorner:
                startActivity(new Intent(this, CircleActivity.class));
                break;
            case R.id.bt_fresco_spimg:
                startActivity(new Intent(this, ProgressActivity.class));
                break;
            case R.id.bt_fresco_gif:
                startActivity(new Intent(this, GifActivity.class));
                break;
            case R.id.bt_fresco_multi:
                startActivity(new Intent(this, MultiActivity.class));
                break;
            case R.id.bt_fresco_crop:
                startActivity(new Intent(this, FrescoCropActivity.class));
                break;
            case R.id.bt_fresco_jpeg:
                startActivity(new Intent(this, ProgressiveActivity.class));
                break;
            case R.id.bt_fresco_listener:
                startActivity(new Intent(this, LoadListenerActivity.class));
                break;
            case R.id.bt_fresco_resize:
                startActivity(new Intent(this, ChangeActivity.class));
                break;
            case R.id.bt_fresco_modifyImg:
                break;
            case R.id.bt_fresco_autoSizeImg:
                startActivity(new Intent(this, LoadingActivity.class));
                break;
        }
    }
}
