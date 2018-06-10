package com.example.com.fresco_demo2;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

public class MultiActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mSdv;
    /**
     * 先显示低分辨率的图，然后是高分辨率的图
     */
    private Button mBtFrescoMultiImg;
    /**
     * 本地缩略图预览
     */
    private Button mBtFrescoThumbnailImg;
    /**
     * 本地图片复用
     */
    private Button mBtFrescoMultiplxImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        initView();
    }

    private void initView() {
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
        mBtFrescoMultiImg = (Button) findViewById(R.id.bt_fresco_multiImg);
        mBtFrescoMultiImg.setOnClickListener(this);
        mBtFrescoThumbnailImg = (Button) findViewById(R.id.bt_fresco_thumbnailImg);
        mBtFrescoThumbnailImg.setOnClickListener(this);
        mBtFrescoMultiplxImg = (Button) findViewById(R.id.bt_fresco_multiplxImg);
        mBtFrescoMultiplxImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //先显示低分辨率的图（小图） 然后加载高分率的图
            case R.id.bt_fresco_multiImg:
                Uri minUri = Uri.parse("http://upload.northnews.cn/2014/0109/thumb_136_92_1389274956651.jpg");
                Uri maxUri = Uri.parse("http://ww4.sinaimg.cn/mw690/9844520fjw1f4fqrpw1fvj21911wlb2b.jpg");

                //控制加载的图片
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setLowResImageRequest(ImageRequest.fromUri(minUri))
                        .setImageRequest(ImageRequest.fromUri(maxUri))
                        .build();
                //加载图片
                mSdv.setController(controller);

                break;
            case R.id.bt_fresco_thumbnailImg: //请求本地的图片
                Uri cache = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/kill.jpg"));
                //加载请求
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(cache)
                        .setLocalThumbnailPreviewsEnabled(true) //开启缩略图的预览
                        .build();
                //控制图片的加载
                AbstractDraweeController controll = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .build();
                mSdv.setController(controll);
                break;
            case R.id.bt_fresco_multiplxImg: //先加载本地图片 如果没有就从网络上加载
                //本地图片
                Uri cacheUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/killll.jpg"));
                //网络图片
                Uri netUri = Uri.parse("http://wx2.sinaimg.cn/orj480/be3de89dly1fktey9tpdoj20hs0hsglw.jpg");
                //创建ImageRequest对象
                ImageRequest request1 = ImageRequest.fromUri(cacheUri);
                ImageRequest request2 = ImageRequest.fromUri(netUri);
                ImageRequest[] requests = {request1,request2};
                AbstractDraweeController contr = Fresco.newDraweeControllerBuilder()
                        .setFirstAvailableImageRequests(requests) //设置图片的顺序 数组中的放置的顺序决定
                        .setOldController(mSdv.getController())
                        .build();
               //给控件设置适配器
                mSdv.setController(contr);
                break;
        }
    }
}
