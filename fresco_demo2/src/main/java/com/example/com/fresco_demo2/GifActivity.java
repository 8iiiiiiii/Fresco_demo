package com.example.com.fresco_demo2;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class GifActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sdv;
    private Button bt_fresco_askImg;
    private Button bt_fresco_stopAnim;
    private Button bt_fresco_startAnim;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        initView();
        bt_fresco_askImg.setOnClickListener(this);
        bt_fresco_stopAnim.setOnClickListener(this);
        bt_fresco_startAnim.setOnClickListener(this);

    }

    private void initView() {
        sdv = (SimpleDraweeView) findViewById(R.id.sdv);
        bt_fresco_askImg = (Button) findViewById(R.id.bt_fresco_askImg);
        bt_fresco_stopAnim = (Button) findViewById(R.id.bt_fresco_stopAnim);
        bt_fresco_startAnim = (Button) findViewById(R.id.bt_fresco_startAnim);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_fresco_askImg:
                uri = Uri.parse("http://img001.yygexing.com/20170607/9e4e6de3c64e850698435009e066c1dc.gif");
                AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(false) //是否自动播放
                        .setOldController(sdv.getController()) //进行复用 内存优化
                        .build();
                sdv.setController(controller);
                break;
            case R.id.bt_fresco_stopAnim:
                Animatable animatable = sdv.getController().getAnimatable();
                if(animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }
                break;
            case R.id.bt_fresco_startAnim:
                Animatable animatable1 = sdv.getController().getAnimatable();
                if(animatable1 != null && !animatable1.isRunning()) {
                    animatable1.start();
                }
                break;
        }
    }
}
