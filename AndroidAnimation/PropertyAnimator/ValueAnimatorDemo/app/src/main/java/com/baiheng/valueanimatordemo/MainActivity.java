package com.baiheng.valueanimatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

/**
 * ValueAnimator动画基本使用
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtn;
    private Button mStartAnimBtn;
    private TextView mTv;
    private TextView mCharacterTv;
    private MyPointView mPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.btn_start_animation);
        mStartAnimBtn = (Button) findViewById(R.id.btn_start_value_anim);
        mTv = (TextView) findViewById(R.id.tv_content);
        mCharacterTv = (TextView) findViewById(R.id.tv_character_content);
        mPointView = (MyPointView) findViewById(R.id.my_point_view);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doTranslateAnimation();
                doCharacterAnimation();
            }
        });
        mStartAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPointView.doPointAnim();   //ValueAnimator中ofObject使用示例
            }
        });

    }

    private void doTranslateAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue =( int) valueAnimator.getAnimatedValue();
                mTv.layout(curValue,curValue,curValue + mTv.getWidth(), curValue + mTv.getHeight());

            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }

    /**
     * 自定义Evaluator，使用oObject示例
     */
    private void doCharacterAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),'A',
                'Z');
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char text = (char) valueAnimator.getAnimatedValue();
                mCharacterTv.setText(String.valueOf(text));
            }
        });
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }
}
