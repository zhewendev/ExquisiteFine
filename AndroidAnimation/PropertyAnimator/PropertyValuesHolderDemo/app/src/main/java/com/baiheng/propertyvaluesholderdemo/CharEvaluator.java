package com.baiheng.propertyvaluesholderdemo;

import android.animation.TypeEvaluator;

/**
 * 自定义一个字母Evaluator，通过进度值计算当前字母
 */
public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float v, Character character, Character t1) {
        int startInt  = (int)character;
        int endInt = (int)t1;
        int curInt = (int)(startInt + v *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
