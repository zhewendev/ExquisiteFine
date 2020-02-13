package com.baiheng.propertyvaluesholderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * PropertyValesHolder动画示例
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnStartAnim;
    private TextView mTvContent1,mTvContent2;
    private ImageView mImgKeyFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStartAnim = (Button) findViewById(R.id.btn_start_anim);
        mTvContent1 = (TextView) findViewById(R.id.tv_content_1);
        mTvContent2 = (TextView) findViewById(R.id.tv_content_2);
        mImgKeyFrame = (ImageView) findViewById(R.id.img_key_frame);

        mBtnStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doPropertyValuesHolderAnim();
//                doOfObjectAnim();
                doKeyFrameAnim();
            }
        });
    }
    // PropertyValuesHolder动画演示1
    private void doPropertyValuesHolderAnim() {
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation",
                60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
        PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor",
                0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mTvContent1,rotationHolder,colorHolder);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }
    // PropertyValuesHolder的ofObject动画演示
    private void doOfObjectAnim() {
        PropertyValuesHolder charHolder = PropertyValuesHolder.ofObject("CharText",new CharEvaluator(),'A','Z');
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mTvContent2, charHolder);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
    // KeyFrame动画示例
    private void doKeyFrameAnim() {
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10);
        Animator animator = ObjectAnimator.ofPropertyValuesHolder(mImgKeyFrame,frameHolder);
        animator.setDuration(1000);
        animator.start();
    }
}
