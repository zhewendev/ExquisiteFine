package com.baiheng.animatorsetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * AnimatorSet动画示例
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnStartAnim;
    private TextView mTvContent1, mTvContent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStartAnim = (Button) findViewById(R.id.btn_start_anim);
        mTvContent1 = (TextView) findViewById(R.id.tv_content_1);
        mTvContent2 = (TextView) findViewById(R.id.tv_content_2);

        mBtnStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doPlaySequentiallyAnimator();
//                doPlayTogetherAnimator();
//                doPlayFreeAnimator();
//                doPlayXmlAnimator();
            }
        });
    }
    // 所有动画依次播放
    private void doPlaySequentiallyAnimator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTvContent1, "BackgroundColor",  0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTvContent1, "translationY", 0, 300, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTvContent2
                , "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
    // 所有动画一起播放,即同一个时间点开始播放
    private void doPlayTogetherAnimator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTvContent1
                , "BackgroundColor",  0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTvContent1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTvContent2, "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
    // 自由组合动画的播放顺序
    private void doPlayFreeAnimator() {
        ObjectAnimator tv1BgAnimator = ObjectAnimator.ofInt(mTvContent1, "BackgroundColor",  0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator tv1TranslateY = ObjectAnimator.ofFloat(mTvContent1, "translationY", 0, 400, 0);
        ObjectAnimator tv2TranslateY = ObjectAnimator.ofFloat(mTvContent2
                , "translationY", 0, 400, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1BgAnimator);
        animatorSet.setDuration(2000);
        animatorSet.start();
        //动画监听
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
    // XML实现valueAnimator等动画
    private void doPlayXmlAnimator() {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.valueanimator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int offSet = (int) valueAnimator.getAnimatedValue();
                mTvContent1.layout(offSet, offSet, offSet + mTvContent1.getWidth(),offSet + mTvContent1.getHeight());
            }
        });
        valueAnimator.start();

//        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.objectanimator);
//        animator.setTarget(mTvContent1);
//        animator.start();
//
//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(MyActivity.this,
//                R.animator.animatorset);
//        set.setTarget(mTvContent1);
//        set.start();

    }
}
