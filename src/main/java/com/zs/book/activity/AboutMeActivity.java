package com.zs.book.activity;/**
 * Created by admin on 2017/2/23.
 */

import com.zs.book.R;
import com.zs.book.base.BaseTitleActivity;
import com.zs.book.view.viewhelper.SampleHelper;

/**
 * 描述 关于我
 * 作者 zs
 * 时间 2017/2/23
 */
public class AboutMeActivity extends BaseTitleActivity {
    @Override
    protected void initBefore() {

    }
    @Override
    protected void init() {
        SampleHelper.with(this).init().loadAbout();
    }
    @Override
    protected int getLayout() {
        return R.layout.sample_view;
    }
}
