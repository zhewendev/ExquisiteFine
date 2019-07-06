package com.baiheng.maskfilterdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BlurMaskFilterView extends View {

    private Paint mPaint;
    private Context mContext;
    private BlurMaskFilter blurMaskFilter1 = new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL);
    private BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(20,BlurMaskFilter.Blur.OUTER);
    private BlurMaskFilter blurMaskFilter3 = new BlurMaskFilter(20,BlurMaskFilter.Blur.INNER);
    private Bitmap mSrcBitmap;
    private Bitmap mShadowBitmap;
    public BlurMaskFilterView (Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init () {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.SOLID));
        mSrcBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.kal);
        mShadowBitmap = mSrcBitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(100,100,500,500,mPaint);
        mPaint.setMaskFilter(blurMaskFilter1);
        canvas.drawRect(600,100,1000,500,mPaint);
        mPaint.setMaskFilter(blurMaskFilter2);
        canvas.drawRect(100,600, 500,1000,mPaint);
        mPaint.setMaskFilter(blurMaskFilter3);
        canvas.drawRect(600,600,1000,1000,mPaint);
        mPaint.setColor(Color.DKGRAY);
        canvas.drawBitmap(mShadowBitmap, 100,1100,mPaint);
        canvas.drawBitmap(mSrcBitmap,100,1100,null);
    }
}
