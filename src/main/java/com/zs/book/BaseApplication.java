package com.zs.book;/**
 * Created by admin on 2017/2/20.
 */

import android.app.Application;

import com.tencent.stat.StatConfig;
import com.zs.book.base.BaseActivity;

/**
 * 作者 zs
 */
public class BaseApplication extends Application {
    private static BaseActivity activity;
    public static BaseActivity getActivity() {
        return activity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String open_appid = "开放平台appid";
        StatConfig.setAppKey(this, "Aqc" + open_appid);
    }
}
