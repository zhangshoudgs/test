package com.zs.book.activity.home;

import com.zs.book.R;
import com.zs.book.base.BaseFragment;
import com.zs.book.view.FlowingDrawer.ElasticDrawer;
import com.zs.book.view.FlowingDrawer.FlowingDrawer;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午1:31
 * Mail: specialcyci@gmail.com
 */
public class ProfileFragment extends BaseFragment {

    private FlowingDrawer mDrawer;

    @Override
    protected void init() {
//        mPullToRefreshView = findViewBy(R.id.pull_to_refresh);
//        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mPullToRefreshView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mPullToRefreshView.setRefreshing(false);
//                    }
//                }, 1000);
//            }
//        });

        mDrawer = findViewBy(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    showToast("关闭!");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                showToast("打开!  openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return mPullToRefreshView.dispatchTouchEvent(ev)||mDrawer.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        return mPullToRefreshView.onTouchEvent(ev)||mDrawer.onTouchEvent(ev);
//    }

    @Override
    protected int getLayout() {
        return R.layout.profile;
    }

}
