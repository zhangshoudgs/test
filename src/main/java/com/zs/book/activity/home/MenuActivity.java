package com.zs.book.activity.home;

import android.app.ActivityOptions;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.zs.book.BaseApplication;
import com.zs.book.R;
import com.zs.book.activity.AboutMeActivity;
import com.zs.book.base.BaseActivity;

public class MenuActivity extends BaseActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;
    private ResideMenuItem aboutMe;

    @Override
    protected void initBefore() {
    }
    @Override
    protected void init() {
        setUpMenu();
        changeFragment(new HomeFragment());
    }
    @Override
    protected int getLayout() {
        return R.layout.main;
    }

    private void setUpMenu() {
        // attach to current activity;
        resideMenu = new ResideMenu(this);
//        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip. 
        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome     = new ResideMenuItem(this, R.drawable.icon_home,     "首页");
        itemProfile  = new ResideMenuItem(this, R.drawable.icon_profile,  "首页之下");
        itemCalendar = new ResideMenuItem(this, R.drawable.icon_calendar, "日期");
        itemSettings = new ResideMenuItem(this, R.drawable.icon_settings, "设置");
        aboutMe = new ResideMenuItem(this, R.drawable.icon_settings, "关于");

        itemHome.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);
        itemSettings.setOnClickListener(this);
        aboutMe.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(aboutMe, ResideMenu.DIRECTION_RIGHT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return resideMenu.dispatchTouchEvent(ev);
//    }

    @Override
    public void onClick(View view) {

        if (view == itemHome){
            changeFragment(new HomeFragment());
        }else if (view == itemProfile){
            changeFragment(new ProfileFragment());
        }else if (view == itemCalendar){
            changeFragment(new CalendarFragment());
        }else if (view == itemSettings){
            changeFragment(new SettingsFragment());
        }else if (view == aboutMe){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(getJumpIntent(AboutMeActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }else{
                startActivity(getJumpIntent(AboutMeActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);
            }
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(BaseApplication.getActivity(), "打开!", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void closeMenu() {
            Toast.makeText(BaseApplication.getActivity(), "关闭!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
