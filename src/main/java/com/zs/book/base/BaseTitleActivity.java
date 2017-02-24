package com.zs.book.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zs.book.R;

/**
 * Created by admin on 2017/2/17.
 */
public abstract class BaseTitleActivity extends BaseActivity implements View.OnClickListener{
    private View inflate;
    private TextView title_left;
    private TextView title_tv;
    private TextView title_right;

    @Override
    public void setContentView(int layoutResID) {
        inflate = View.inflate(this, R.layout.base_title_activity, null);
        FrameLayout container = (FrameLayout) inflate.findViewById(R.id.container);
        initTitleView();
        View.inflate(this, layoutResID, container);
        super.setContentView(inflate);
    }

    private void initTitleView() {
        title_left = findViewBy(R.id.title_left,this);
        title_tv = findViewBy(R.id.title_tv,this);
        title_right = findViewBy(R.id.title_right,this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.title_left:
                onBackPressed();
                break;
            case R.id.title_tv:
                onTitleClick();
                break;
            case R.id.title_right:
                onSubmitClick();
                break;
        }
    }

    /**
     * 中间的标题
     */
    protected void onTitleClick() {
    }

    /**
     * 右侧的确定
     */
    protected void onSubmitClick() {
    }

    /**
     * 获取view
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewBy(int resId, View.OnClickListener oc){
        try{
            T viewById = (T)inflate.findViewById(resId);
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
            return (T)inflate.findViewById(resId);
        }catch (Exception e){
            throw e;
        }
    }
}
