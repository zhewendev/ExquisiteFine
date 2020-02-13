package com.baiheng.valueanimatordemo;

import android.animation.TypeEvaluator;

/**
 * 自定义Evaluator，重写evaluate方法
 */
public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float v, Character o, Character t1) {
        int startInt = (int) o;
        int endInt = (int) t1;
        int curInt = (int) (startInt + v * (endInt - startInt));
        char result = (char) curInt;
        return result;
    }
}
