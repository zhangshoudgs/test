package com.zs.book.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.zs.book.utils.GlideUtils;

public abstract class BaseFragment extends Fragment {
	protected static Activity base;
	protected View layout;
	protected SharedPreferences sp;
	protected int screenWidth;
	protected int screenHeigh;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		base = getActivity();
		DisplayMetrics dm = new DisplayMetrics();
		// 获取屏幕信息
		base.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;

		sp = base.getSharedPreferences("config", Context.MODE_PRIVATE);
		layout = inflater.inflate(getLayout(), null);
		init();
		return layout;
	}

	protected abstract void init();

	protected abstract int getLayout();

	/**
	 * @在主线程中定义utils ImageUtils utils =
	 *               ImageUtils.newImageUtils(MainActivity.this);
	 * @param iv
	 *            设置图片的ImageView
	 * @param path
	 *            图片的路径
	 */
	protected void setImageViewBitmap(final ImageView iv, String path) {
		if (path.endsWith(".gif")) {
			return;
		}
		GlideUtils.load(path,iv);
	}

	protected void tooast(String msg) {
		Toast.makeText(base, msg, Toast.LENGTH_SHORT).show();
	}
}
