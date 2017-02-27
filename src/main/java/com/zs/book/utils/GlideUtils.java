package com.zs.book.utils;/**
 * Created by admin on 2017/2/20.
 */

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.zs.book.BaseApplication;
import com.zs.book.R;

/**
 * 图片加载类
 * 作者 zs
 * compile 'com.github.bumptech.glide:glide:3.6.0'
 */
public class GlideUtils {

    public static void load(String url, ImageView view) {
        load(url, view, R.mipmap.ic_launcher);
    }

    /**
     * 加载图片
     */
    public static void load(String url, ImageView view, @DrawableRes int defaultImage) {
        if (view==null) return;
        getGlide(url).placeholder(defaultImage).crossFade().into(view);
    }
    /**
     * 加载圆形图片
     */
    public static void loadCircle(String url, ImageView view) {
        loadCircle(url, view, R.mipmap.ic_launcher);
    }

    public static void loadCircle(String url, ImageView view, @DrawableRes int defaultImage) {
        if (view==null) return;
        getGlide(url).transform(new CircleTransUtils(view.getContext())).placeholder(defaultImage).crossFade().into(view);
    }

    public static void loadHeadCircle(String url, ImageView view) {
        if (view==null) return;
        Context context = view.getContext();
        int avatarSize = context.getResources().getDimensionPixelSize(R.dimen.dp64);
        getGlide(url).transform(new CircleTransUtils(context))
                .override(avatarSize, avatarSize)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher).crossFade().into(view);
    }

    private static DrawableRequestBuilder<String> getGlide(String url) {
        return Glide.with(BaseApplication.getActivity()).load(url).centerCrop();
    }

    public static void getScreen(CallBack<Screen> cb) {
        DisplayMetrics dm = new DisplayMetrics();
        // 获取屏幕信息
        BaseApplication.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        Screen screen = new Screen();
        screen.width = dm.widthPixels;
        screen.height = dm.heightPixels;
        cb.callBack(screen);
    }


    public static class Screen {
        public int width;
        public int height;
    }
}
