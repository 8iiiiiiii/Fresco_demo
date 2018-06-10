package com.example.com.fresco_demo2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class ChangeActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mSdvFrescoResize;
    /**
     * 修内存中改图片大小
     */
    private Button mBtFrescoResize;
    /**
     * 旋转图片
     */
    private Button mBtFrescoRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        initView();

    }

    private void initView() {
        mSdvFrescoResize = (SimpleDraweeView) findViewById(R.id.sdv_fresco_resize);
        mBtFrescoResize = (Button) findViewById(R.id.bt_fresco_resize);
        mBtFrescoResize.setOnClickListener(this);
        mBtFrescoRotate = (Button) findViewById(R.id.bt_fresco_rotate);
        mBtFrescoRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_fresco_resize:
                int width = 450;
                int height = 650;
                Uri uri = Uri.parse("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1528336071&di=14adcefafc60c7dc428f8ef91eec88bf&src=http://img5.duitang.com/uploads/item/201508/29/20150829205112_Z4zLu.jpeg");
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(new ResizeOptions(width, height)).build();
                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(mSdvFrescoResize.getController())
                        .setImageRequest(request)
                        .build();
                mSdvFrescoResize.setController(controller);
                break;
            case R.id.bt_fresco_rotate:
                Uri uri2 = Uri.parse("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1528336071&di=14adcefafc60c7dc428f8ef91eec88bf&src=http://img5.duitang.com/uploads/item/201508/29/20150829205112_Z4zLu.jpeg");
                RotationOptions rotationOptions = RotationOptions.forceRotation(RotationOptions.ROTATE_90);
                ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(uri2)
                        .setRotationOptions(RotationOptions.autoRotate())
                        .setRotationOptions(rotationOptions)//旋转的时候要使用RotationOptions类
                        .build();//但貌似Fresco在旋转的功能上不是很好
                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request1)
                        .setOldController(mSdvFrescoResize.getController()).build();
                mSdvFrescoResize.setController(controller1);
                break;
        }
    }
}
