package com.example.com.fresco_demo2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class ProgressiveActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mSdv;
    /**
     * 请求网络图片
     */
    private Button mBtFrescoAskImg;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressive);
        initView();
    }

    private void initView() {
        mSdv = (SimpleDraweeView) findViewById(R.id.sdv);
        mBtFrescoAskImg = (Button) findViewById(R.id.bt_fresco_askImg);
        mBtFrescoAskImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_fresco_askImg:
                uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528301325217&di=33ad569c7a3ea7ce2a0b74af1964cc5b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140714%2F240451-140G4062Z663.jpg");
                ProgressiveJpegConfig progressiveJpegConfig = new ProgressiveJpegConfig() {
                    //进行解码
                    @Override
                    public int getNextScanNumberToDecode(int scanNumber) {
                        return scanNumber + 4;
                    }

                    @Override
                    public QualityInfo getQualityInfo(int scanNumber) {
                        boolean b = scanNumber >= 5;

                        return ImmutableQualityInfo.of(scanNumber, b, false);
                    }
                };
                ImagePipelineConfig.newBuilder(this).setProgressiveJpegConfig(progressiveJpegConfig).build();

                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)//打开渐变渲染
                        .build();
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setTapToRetryEnabled(true)//开启用户点击，重新加载图片
                        .setOldController(mSdv.getController())
                        .build();
                mSdv.setController(controller);
                break;
        }
    }
}
