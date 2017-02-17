package com.zs.book.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.LruCache;

public class ImageUtils {

	private LruCache<String, Bitmap> imgCache;

	private FileUtils fileUtils;
	private ExecutorService DownImageThread;

	private static ImageUtils instance;

	private static int screenWidth;

	private static int screenHeigh;

	public static ImageUtils newImageUtils(Activity context) {
		DisplayMetrics dm = new DisplayMetrics();
		// 获取屏幕信息
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;
		if (instance == null)
			instance = new ImageUtils(context);
		return instance;
	}

	private ImageUtils(Context context) {
		fileUtils = new FileUtils(context);
		// 为缓存区分配大小
		imgCache = new LruCache<String, Bitmap>((int) Runtime.getRuntime()
				.maxMemory() / 8) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getByteCount();
			}
		};
		// 参数 为 同时启动多少条线程
		DownImageThread = Executors.newFixedThreadPool(3);
	}

	// 存储到缓存区
	public void saveBitmapToMemory(String name, Bitmap bmp) {
		imgCache.put(name, bmp);
	}

	// 从缓存区读取
	public Bitmap getBitmapFromMemory(String name) {
		return imgCache.get(name);
	}

	/**
	 * 必须在主线程中调用该方法
	 * 
	 * @param url
	 * @param listener
	 * @return
	 */
	public Bitmap getImageBitmap(final String url,
			final OnImageListener listener) {
		// 键和存储的名称
		final String path = url.replaceAll("[\\W]", "");
		// 从缓存中读取
		Bitmap bmp;
		// 缓存中有，直接使用缓存
		if ((bmp = getBitmapFromMemory(path)) != null) {
//			System.out.println("------从缓存中读取");
			return bmp;
		}
		if ((bmp = fileUtils.readBitmap(path)) != null) {
			// 如果SD中有，存储到缓存，并且使用
//			System.out.println("------从SD卡中读取");
			saveBitmapToMemory(path, bmp);
			return bmp;
		} else {
			// 下载
			final Handler handler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// 返回
					listener.onImageSuccess((Bitmap) msg.obj);
				};
			};
//			System.out.println("-------使用网络下载");
			DownImageThread.execute(new Runnable() {
				@Override
				public void run() {
					// 下载图片
					// 线程中返回，必须使用回调
					try {
						// 下载完毕
						URL u = new URL(url);
						InputStream is = u.openStream();
						Bitmap bitmap = BitmapFactory.decodeStream(is);
						int width = bitmap.getWidth();
						int height = bitmap.getHeight();
//						System.out.println("------width--" +width+"       height  "+height);
//						System.out.println("------screenWidth--" +screenWidth+"       screenHeigh  "+screenHeigh);
//						System.out.println("--------" + bitmap.getByteCount());
						// 存储
						saveBitmapToMemory(path, bitmap);
						fileUtils.saveBitmap(path, bitmap);
						// 发送
						Message msg = handler.obtainMessage();
						msg.obj = bitmap;
						handler.sendMessage(msg);
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return null;
	}

	// 回调接口
	public interface OnImageListener {
		public void onImageSuccess(Bitmap bmp);
	}
}
