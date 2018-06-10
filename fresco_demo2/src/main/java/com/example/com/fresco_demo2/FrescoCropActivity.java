package com.example.com.fresco_demo2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class FrescoCropActivity extends AppCompatActivity {

    private SimpleDraweeView draweeView;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_crop);

        draweeView = findViewById(R.id.my_image_view);
        uri = Uri.parse("http://ww1.sinaimg.cn/large/0065oQSqly1frv032vod8j30k80q6gsz.jpg");

        draweeView.setImageURI(uri);
    }

    public void cut(View view){

        //调用
        draweeView.setLayoutParams(new LinearLayout.LayoutParams(600, 400));
        CutProcess cutProcess = new CutProcess(0, 0, 0.5f, 0.5f);
        cutPic(cutProcess);


    }

    //裁剪的方法
    private void cutPic(BasePostprocessor processor) {
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(processor)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(build)
                .build();

        draweeView.setController(controller);
    }
}

