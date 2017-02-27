package com.zs.book.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;


public class CircleTransUtils extends BitmapTransformation {

    private static final int STROKE_WIDTH = 6;
    private float radius;

    public CircleTransUtils(Context context) {
        this(context,0);
    }
    public CircleTransUtils(Context context, int dp) {
        super(context);
        radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }
    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap source, int outWidth, int outHeight) {

        if (source == null) return null;
        int size = Math.min(outWidth, outHeight);

        Bitmap result = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);
        if (radius == 0){
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            canvas.drawCircle(r, r, r - STROKE_WIDTH / 2, paint);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, r, r, paint);
        }else{
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
        }
        source.recycle();
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }
}
