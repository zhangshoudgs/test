package com.zs.book.activity;


import com.zs.book.R;
import com.zs.book.base.BaseTitleActivity;

/**
 * Created by admin on 2017/2/17.
 */
public class HomeActivity extends BaseTitleActivity {

    @Override
    protected void initBefore() {
        //测试测试
//        StatConfig.setAutoExceptionCaught(true);
//        StatService.trackCustomEvent(this,"onCreate","");
    }

    @Override
    protected void init() {
//        SampleHelper.with(this).init().loadAbout();
    }

    @Override
    protected int getLayout() {
        return R.layout.sample_view;
    }

//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return resideMenu.dispatchTouchEvent(ev);
//    }
}
