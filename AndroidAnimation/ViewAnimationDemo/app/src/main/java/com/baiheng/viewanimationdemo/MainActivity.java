package com.baiheng.viewanimationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * ViewAnimation代码示例，包含xml实现和code实现
 */
public class MainActivity extends AppCompatActivity {

    private Button mScaleBtn;
    private Animation mScaleAnimation;
    private ScaleAnimation mCodeScaleAnimaiton;
    private TranslateAnimation mCodeTranslateAnimation;
    private AnimationSet mSetAnimation;
    private TextView mContentTv;    //xml实现scale动画
    private TextView mCodeContentTv;    //code实现scale动画
    private TextView mCodeSetContentTv; //code实现Set动画


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scale);
        mCodeScaleAnimaiton = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mCodeScaleAnimaiton.setDuration(500);
        mCodeScaleAnimaiton.setRepeatCount(1);
        mCodeScaleAnimaiton.setRepeatMode(Animation.RESTART);
        mCodeScaleAnimaiton.setInterpolator(new AccelerateDecelerateInterpolator());

        mCodeTranslateAnimation = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80,
                Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80);
        mCodeTranslateAnimation.setDuration(2000);
        mCodeTranslateAnimation.setFillBefore(true);
        mSetAnimation = new AnimationSet(true);
        mSetAnimation.addAnimation(mCodeScaleAnimaiton);
        mSetAnimation.addAnimation(mCodeTranslateAnimation);
        mSetAnimation.setDuration(3000);
        mSetAnimation.setFillAfter(true);
        mSetAnimation.setInterpolator(new BounceInterpolator());

        mScaleBtn = (Button) findViewById(R.id.btn_scale_animation);
        mContentTv = (TextView) findViewById(R.id.tv_content);
        mCodeContentTv = (TextView) findViewById(R.id.code_tv_content);
        mCodeSetContentTv = (TextView) findViewById(R.id.code_set_tv_content);
        mScaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContentTv.startAnimation(mScaleAnimation);
                mCodeContentTv.startAnimation(mCodeScaleAnimaiton);
                mCodeSetContentTv.startAnimation(mSetAnimation);
            }
        });
    }
}
