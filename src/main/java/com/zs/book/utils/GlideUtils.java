package com.zs.book.utils;/**
 * Created by admin on 2017/2/20.
 */

import android.support.annotation.DrawableRes;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zs.book.BaseApplication;
import com.zs.book.R;

/**
 * 图片加载类
 * 作者 zs
 *  compile 'com.github.bumptech.glide:glide:3.6.0'
 */
public class GlideUtils {

    public static void load(String url,ImageView view){
        Glide.with(BaseApplication.getActivity()).load(url).centerCrop().placeholder(R.mipmap.ic_launcher).crossFade().into(view);
    }

    /**
     * 加载图片
     * @param url
     * @param view
     * @param defaultImage
     */
    public static void load(String url,ImageView view,@DrawableRes int defaultImage){
        Glide.with(BaseApplication.getActivity()).load(url).centerCrop().placeholder(defaultImage).crossFade().into(view);
    }

    public static void getScreen(CallBack<Screen> cb){
        DisplayMetrics dm = new DisplayMetrics();
        // 获取屏幕信息
        BaseApplication.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        Screen screen = new Screen();
        screen.width = dm.widthPixels;
        screen.height = dm.heightPixels ;
        cb.callBack(screen);
    }


    public static class Screen{
        public int width;
        public int height;
    }
}
