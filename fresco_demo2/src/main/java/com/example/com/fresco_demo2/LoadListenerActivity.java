package com.example.com.fresco_demo2;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

public class LoadListenerActivity extends AppCompatActivity {

    private SimpleDraweeView mListenerMyImageView;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_listener);
        uri = Uri.parse("http://www.jj20.com/up/img/7442.jpg");
        initView();
    }

    private void initView() {
        mListenerMyImageView = (SimpleDraweeView) findViewById(R.id.listener_my_image_view);
        BaseControllerListener<ImageInfo> baseControllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                FLog.d("Final image received! " +
                                "Size %d x %d",
                        "Quality level %d, good enough: %s, full quality: %s",
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        qualityInfo.getQuality(),
                        qualityInfo.isOfGoodEnoughQuality(),
                        qualityInfo.isOfFullQuality());
                Log.e("LoadListenerActivity", "onFinalImageSet: " );
                Toast.makeText(LoadListenerActivity.this, "onFinalImageSet", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                Log.e("LoadListenerActivity", "onFailure: " );
                Toast.makeText(LoadListenerActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                FLog.e(getClass(), throwable, "Error loading %s", id);
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                super.onIntermediateImageSet(id, imageInfo);
                Toast.makeText(LoadListenerActivity.this, "onIntermediateImageSet", Toast.LENGTH_SHORT).show();
                Log.e("LoadListenerActivity", "onIntermediateImageSet: " );
                FLog.d("onIntermediateImageSet","Intermediate image received");
            }
        };
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(baseControllerListener)
                .setUri(uri)
                .build();
        mListenerMyImageView.setController(controller);
    }
}
