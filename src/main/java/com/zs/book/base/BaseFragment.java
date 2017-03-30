package com.zs.book.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.zs.book.utils.GlideUtils;

public abstract class BaseFragment extends Fragment {
	protected static Activity activity;
	protected View layout;
	protected SharedPreferences sp;
	protected int screenWidth;
	protected int screenHeigh;
	private static Toast toast;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		layout = inflater.inflate(getLayout(), container,false);
		activity = getActivity();
		DisplayMetrics dm = new DisplayMetrics();
		// 获取屏幕信息
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;

		sp = activity.getSharedPreferences("config", Context.MODE_PRIVATE);
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

	protected static void showToast(String msg) {
		if (toast==null)
			toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
		else toast.setText(msg);
		toast.show();
	}

	protected <T extends View>T findViewBy(@IdRes int id) {
		try{
			return (T) layout.findViewById(id);
		}catch (Exception e){
			throw e;
		}
	}
}
