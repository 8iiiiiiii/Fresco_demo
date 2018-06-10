package com.example.com.fresco_demo2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class LoadingActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 点击动态加载图片
     */
    private Button mBtFrescoLoading;
    private LinearLayout mLodingLine;
    private SimpleDraweeView mSdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
    }

    private void initView() {
        mBtFrescoLoading = (Button) findViewById(R.id.bt_fresco_loading);
        mBtFrescoLoading.setOnClickListener(this);
        mLodingLine = (LinearLayout) findViewById(R.id.loding_line);

        //手动创建控件
        mSdv = new SimpleDraweeView(this);
        //设置控件的宽高比 必须设置！ 就像XML里控件必须要有宽高一样
        mSdv.setAspectRatio(0.5f); //最大程度展示图片
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_fresco_loading:
                Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528300107126&di=7dd1618788df76e4546a8fa927816b58&imgtype=0&src=http%3A%2F%2Fwww.wndhw.com%2Fxiezhen%2Fshuaige%2Fimages%2Fsg001_1.jpg");
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).build();
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setOldController(mSdv.getController())
                        .setImageRequest(request)
                        .build();
                mSdv.setController(controller);
                //添加控件到子布局
                mLodingLine.addView(mSdv);
                break;
        }
    }
}
