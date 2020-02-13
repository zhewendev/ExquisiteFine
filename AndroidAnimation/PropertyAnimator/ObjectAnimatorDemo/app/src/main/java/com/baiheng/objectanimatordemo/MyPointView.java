package com.baiheng.objectanimatordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义一个View
 */
public class MyPointView extends View {

    private Paint mPaint;
    private Point mPoint = new Point(100);

    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        canvas.drawCircle(300,300,mPoint.getRadius(),mPaint);
    }

    // 设置控件set方法
    public void setPointRadius(int radius) {
        mPoint.setRadius(radius);
        invalidate();   //强制重绘
    }
}
