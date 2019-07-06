package com.baiheng.maskfilterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRootView = (LinearLayout) findViewById(R.id.root_view);
        mRootView.addView(new BlurMaskFilterView(MainActivity.this));
//        mRootView.addView(new EmbossMaskFilterView(MainActivity.this));
    }
}
