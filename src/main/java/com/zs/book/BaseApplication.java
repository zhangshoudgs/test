package com.zs.book;

import android.app.Application;

import com.zs.book.base.BaseActivity;

/**
 * 作者 zs
 */
public class BaseApplication extends Application {
    private static BaseActivity activity;
    public static BaseActivity getActivity() {
        return activity;
    }

    public static void setActivity(BaseActivity activity) {
        BaseApplication.activity = activity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        String open_appid = "1105124117";
//        StatConfig.setAppKey(this, "Aqc" + open_appid);
        ApplicationUtils.initMiPush(this);
    }
}
