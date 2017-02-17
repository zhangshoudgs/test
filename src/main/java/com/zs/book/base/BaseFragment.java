package com.zs.book.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.zs.book.utils.ImageUtils;

public abstract class BaseFragment extends Fragment {
	protected static Activity base;
	protected View layout;
	protected SharedPreferences sp;
	private ImageUtils utils;
	protected int screenWidth;
	protected int screenHeigh;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		base = getActivity();
		DisplayMetrics dm = new DisplayMetrics();
		// ��ȡ��Ļ��Ϣ
		base.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;
		
		utils = ImageUtils.newImageUtils(base);
		sp = base.getSharedPreferences("config", Context.MODE_PRIVATE);
		layout = inflater.inflate(getLayout(), null);
		init();
		return layout;
	}

	protected abstract void init();

	protected abstract int getLayout();

	/**
	 * @�����߳��ж���utils ImageUtils utils =
	 *               ImageUtils.newImageUtils(MainActivity.this);
	 * @param iv
	 *            ����ͼƬ��ImageView
	 * @param path
	 *            ͼƬ��·��
	 */
	protected void setImageViewBitmap(final ImageView iv, String path) {
		if (path.endsWith(".gif")) {
			return;
		}
		Bitmap bmp = utils.getImageBitmap(path, new ImageUtils.OnImageListener() {
			@Override
			public void onImageSuccess(Bitmap bmp) {
				iv.setImageBitmap(bmp);
			}
		});
		if (bmp != null) {
			iv.setImageBitmap(bmp);
		}
	}

	protected void tooast(String msg) {
		Toast.makeText(base, msg, Toast.LENGTH_SHORT).show();
	}
}
