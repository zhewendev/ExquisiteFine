package com.baiheng.valueanimatordemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * 自定义一个View
 */
public class MyPointView extends View {

    private Point mCurPoint;
    private Paint mPaint;
    public MyPointView(Context context, AttributeSet arrts) {
        super(context, arrts);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurPoint != null) {
            canvas.drawCircle(300,300,mCurPoint.getRadius(),mPaint);
        }
    }

    public void doPointAnim() {
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20), new Point(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }
}
