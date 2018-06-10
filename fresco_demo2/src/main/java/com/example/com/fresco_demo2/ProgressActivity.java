package com.example.com.fresco_demo2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

public class ProgressActivity extends AppCompatActivity {

    private SimpleDraweeView sdv;
    private Uri uri;
    private GenericDraweeHierarchyBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        sdv = (SimpleDraweeView) findViewById(R.id.sdv);

        uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528276257863&di=3489e2aba6de4a8542e8f2a5fc98d5d2&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F157%2F14%2FJ526N2R3H3ZW.jpg");
        builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder.setProgressBarImage(new ProgressBarDrawable()).build();
        sdv.setHierarchy(hierarchy);
        sdv.setImageURI(uri);
    }
}
