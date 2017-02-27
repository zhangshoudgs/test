package com.zs.book.activity.home;

import android.view.View;
import android.widget.FrameLayout;

import com.special.ResideMenu.ResideMenu;
import com.zs.book.R;
import com.zs.book.base.BaseFragment;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午1:33
 * Mail: specialcyci@gmail.com
 */
public class HomeFragment extends BaseFragment {

    private ResideMenu resideMenu;

    @Override
    protected void init() {
        setUpViews();
    }

    @Override
    protected int getLayout() {
        return R.layout.home;
    }

    private void setUpViews() {
        MenuActivity parentActivity = (MenuActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();

        findViewBy(R.id.btn_open_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        // add gesture operation's ignored views
        FrameLayout ignored_view = findViewBy(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
    }

}
