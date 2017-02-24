package com.zs.book;/**
 * Created by admin on 2017/2/24.
 */

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.List;

/**
 * 描述 帮助类
 * 作者 zs
 * 时间 2017/2/24
 */
public class ApplicationUtils {
    public static final String APP_ID = "2882303761517551571";
    public static final String APP_KEY = "5701755171571";
    public static final String TAG = "com.zs.book";
    public static Activity getActivity(){
        return BaseApplication.getActivity();
    }
    public static void initMiPush(Context baseApplication){
        if(shouldInit(baseApplication)) {
            MiPushClient.registerPush(baseApplication, APP_ID, APP_KEY);
        }
        //打开Log
        LoggerInterface newLogger = new LoggerInterface() {
            @Override
            public void setTag(String tag) {
                // ignore
            }
            @Override
            public void log(String content, Throwable t) {
                Log.d(TAG, content, t);
            }
            @Override
            public void log(String content) {
                Log.d(TAG, content);
            }
        };
        Logger.setLogger(baseApplication, newLogger);
    }
    /**
     * 是否需要初始化小米推送
     * @return
     */
    private static boolean shouldInit(Context context) {
        ActivityManager am = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE));
        List<ActivityManager.RunningAppProcessInfo> processInfo = am.getRunningAppProcesses();
        String mainProcessName = context.getPackageName();
        int myPid = android.os.Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfo) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
