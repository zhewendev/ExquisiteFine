package com.baiheng.valueanimatordemo;

import android.animation.TypeEvaluator;

/**
 * 自定义一个Point对象的Evaluator
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float v, Point point, Point t1) {

        int start = point.getRadius();
        int end = t1.getRadius();
        int curValue = (int) (start + v * (end - start));
        return new Point(curValue);
    }
}
