package com.baiheng.objectanimatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * ObjectAnimator使用示例
 */

public class MainActivity extends AppCompatActivity {

    private Button mStartAnim;
    private TextView mAnimContentTv;
    private Button mStartSecondAnim;
    private MyPointView mPointView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartAnim = (Button) findViewById(R.id.btn_start_object_anim);
        mAnimContentTv = (TextView) findViewById(R.id.tv_anim_content);
        mStartSecondAnim = (Button) findViewById(R.id.btn_start_second_object_anim);
        mPointView = (MyPointView) findViewById(R.id.my_point_view);

        mStartAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(mAnimContentTv,"alpha",1,0,1);
                animator.setDuration(2000);
                animator.start();
            }
        });
        mStartSecondAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doPointViewAnim();
            }
        });

    }

    private void doPointViewAnim() {
        ObjectAnimator animator = ObjectAnimator.ofInt(mPointView,"pointRadius",0,300,100);
        animator.setDuration(2000);
        animator.start();
    }
}
