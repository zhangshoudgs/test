package com.zs.book.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.tencent.stat.StatService;
import com.zs.book.BaseApplication;

public abstract class BaseActivity extends FragmentActivity {

    private static Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.setActivity(this);
        initBefore();
        setContentView(getLayout());
        init();
    }

    protected abstract void initBefore();

    protected abstract void init();

    protected abstract int getLayout();

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

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

    public static Intent getJumpIntent(Class activity){
      return new Intent(BaseApplication.getActivity(),activity);
    }

    public static void showToast(String content){
        BaseActivity activity = BaseApplication.getActivity();
        if (activity==null) return;
        if(toast == null){
            toast = Toast.makeText(activity, content, Toast.LENGTH_SHORT);
        }else{
            toast.setText(content);
        }
        toast.show();
    }
}
