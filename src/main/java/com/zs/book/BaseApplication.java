package com.zs.book;/**
 * Created by admin on 2017/2/20.
 */

import android.app.Activity;
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

}
