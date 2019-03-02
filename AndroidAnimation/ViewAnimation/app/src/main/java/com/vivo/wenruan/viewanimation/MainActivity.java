package com.vivo.wenruan.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mAlpahButton, mRotateButton, mScaleButton, mTranslateButton, mGroupButton,
    mTrembleButton,mTvCloseButton,mCustomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlpahButton = (Button) findViewById(R.id.btn_start_alpha_animation);
        mRotateButton = (Button) findViewById(R.id.btn_start_rotate_animation);
        mScaleButton = (Button) findViewById(R.id.btn_start_scale_animation);
    }
}
