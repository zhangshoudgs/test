package com.zs.book.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zs.book.R;
import com.zs.book.base.BaseFragment;
import com.zs.book.utils.GlideUtils;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:28
 * Mail: specialcyci@gmail.com
 */
public class SettingsFragment extends BaseFragment {

    private ImageView ivMenuUserProfilePhoto;

    @Override
    protected void init() {
        NavigationView vNavigation = findViewBy(R.id.vNavigation);
        int headerCount = vNavigation.getHeaderCount();
        if (headerCount>0){
            View headerView = vNavigation.getHeaderView(0);
            ivMenuUserProfilePhoto = (ImageView) headerView.findViewById(R.id.ivMenuUserProfilePhoto);
        }
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Toast.makeText(getActivity(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return false;
            }
        }) ;
        setupHeader();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_menu;
    }

    private void setupHeader() {
        String profilePhoto = "http://www.easyicon.net/api/resizeApi.php?id=1199882&size=128";
        GlideUtils.loadHeadCircle(profilePhoto, ivMenuUserProfilePhoto);
    }

}
