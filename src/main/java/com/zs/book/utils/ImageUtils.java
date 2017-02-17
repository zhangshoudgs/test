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
		// ��ȡ��Ļ��Ϣ
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth = dm.widthPixels;
		screenHeigh = dm.heightPixels;
		if (instance == null)
			instance = new ImageUtils(context);
		return instance;
	}

	private ImageUtils(Context context) {
		fileUtils = new FileUtils(context);
		// Ϊ�����������С
		imgCache = new LruCache<String, Bitmap>((int) Runtime.getRuntime()
				.maxMemory() / 8) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getByteCount();
			}
		};
		// ���� Ϊ ͬʱ�����������߳�
		DownImageThread = Executors.newFixedThreadPool(3);
	}

	// �洢��������
	public void saveBitmapToMemory(String name, Bitmap bmp) {
		imgCache.put(name, bmp);
	}

	// �ӻ�������ȡ
	public Bitmap getBitmapFromMemory(String name) {
		return imgCache.get(name);
	}

	/**
	 * ���������߳��е��ø÷���
	 * 
	 * @param url
	 * @param listener
	 * @return
	 */
	public Bitmap getImageBitmap(final String url,
			final OnImageListener listener) {
		// ���ʹ洢������
		final String path = url.replaceAll("[\\W]", "");
		// �ӻ����ж�ȡ
		Bitmap bmp;
		// �������У�ֱ��ʹ�û���
		if ((bmp = getBitmapFromMemory(path)) != null) {
//			System.out.println("------�ӻ����ж�ȡ");
			return bmp;
		}
		if ((bmp = fileUtils.readBitmap(path)) != null) {
			// ���SD���У��洢�����棬����ʹ��
//			System.out.println("------��SD���ж�ȡ");
			saveBitmapToMemory(path, bmp);
			return bmp;
		} else {
			// ����
			final Handler handler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// ����
					listener.onImageSuccess((Bitmap) msg.obj);
				};
			};
//			System.out.println("-------ʹ����������");
			DownImageThread.execute(new Runnable() {
				@Override
				public void run() {
					// ����ͼƬ
					// �߳��з��أ�����ʹ�ûص�
					try {
						// �������
						URL u = new URL(url);
						InputStream is = u.openStream();
						Bitmap bitmap = BitmapFactory.decodeStream(is);
						int width = bitmap.getWidth();
						int height = bitmap.getHeight();
//						System.out.println("------width--" +width+"       height  "+height);
//						System.out.println("------screenWidth--" +screenWidth+"       screenHeigh  "+screenHeigh);
//						System.out.println("--------" + bitmap.getByteCount());
						// �洢
						saveBitmapToMemory(path, bitmap);
						fileUtils.saveBitmap(path, bitmap);
						// ����
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

	// �ص��ӿ�
	public interface OnImageListener {
		public void onImageSuccess(Bitmap bmp);
	}
}
