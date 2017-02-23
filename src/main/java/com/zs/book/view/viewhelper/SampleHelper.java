package com.zs.book.view.viewhelper;/**
 * Created by admin on 2017/2/23.
 */

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.zs.book.R;

/**
 * 作者 zs
 * 时间 2017/2/23
 */
public class SampleHelper implements View.OnClickListener {

    private Activity activity;
    private static int theme = R.style.AppThemeDark;

    private SampleHelper(Activity activity) {
        this.activity = activity;
    }

    public static SampleHelper with(Activity activity) {
        return new SampleHelper(activity);
    }

    public SampleHelper init() {
        activity.setTheme(theme);

        activity.findViewById(R.id.dark).setOnClickListener(this);
        activity.findViewById(R.id.light).setOnClickListener(this);
        activity.findViewById(R.id.custom).setOnClickListener(this);

        return this;
    }

    public void loadAbout() {
        final FrameLayout flHolder = (FrameLayout) activity.findViewById(R.id.about);

        View build = AboutBuilder.with(activity)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setName("全称")
                .setSubTitle("手机型号")
                .setBrief("我也不知道这一句是不是简介.")
                .setVersionAsAppTitle()
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                .addAction(R.mipmap.err, "测试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(activity, "测试测试", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionsColumnsCount(2)
                .addIntroduceAction((Intent) null)
                .addHelpAction((Intent) null)
                .addChangeLogAction((Intent) null)
                .addRemoveAdsAction((Intent) null)
                .addDonateAction((Intent) null)
                .setWrapScrollView(true)
                .build();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        build.setLayoutParams(lp);
        flHolder.addView(build);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dark:
                if (theme != R.style.AppThemeDark) {
                    theme = R.style.AppThemeDark;
                    activity.recreate();
                }
                break;
            case R.id.light:
                if (theme != R.style.AppThemeLight) {
                    theme = R.style.AppThemeLight;
                    activity.recreate();
                }
                break;

            case R.id.custom:
                if (theme != R.style.AppThemeCustom) {
                    theme = R.style.AppThemeCustom;
                    activity.recreate();
                }
                break;

            default:
                break;
        }
    }
}
