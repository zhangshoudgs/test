package com.zs.book.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBefore();
        setContentView(getLayout());
        init();
    }

    protected abstract void initBefore();

    protected abstract void init();

    protected abstract int getLayout();

    /**
     * 获取view
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewBy(int resId, View.OnClickListener oc){
        try{
            T viewById = (T) findViewById(resId);
            viewById.setOnClickListener(oc);
            return viewById;
        }catch (Exception e){
            throw e;
        }
    }
    /**
     * 获取view
     */
    protected <T extends View> T findViewBy(int resId){
        try{
            return (T) findViewById(resId);
        }catch (Exception e){
            throw e;
        }
    }
}