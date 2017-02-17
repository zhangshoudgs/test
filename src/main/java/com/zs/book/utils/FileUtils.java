package com.zs.book.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * @author computer
 *
 *         存储到磁盘 从sd卡写入
 */
public class FileUtils {
	public String path = "";
	public static final String IMG_PATH = "lrucache/img/";

	public FileUtils(Context context) {
		// 有没有sd卡
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			path = Environment.getExternalStorageDirectory().getAbsolutePath()
					+ "/" + IMG_PATH;
		} else {
			path = context.getCacheDir() + "/" + IMG_PATH;
		}
		new File(path).mkdirs();
	}

	// 存储图片
	public void saveBitmap(String name, Bitmap bmp)
			throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(new File(path, name));
		bmp.compress(CompressFormat.JPEG, 80, fos);
	}

	// 读取
	public Bitmap readBitmap(String name) {
		return BitmapFactory.decodeFile(path + name);
	}

	// 清除图片内存
	public void clearAll() {
		// 遍历
		File[] files = new File(path).listFiles();
		for (File file : files) {
			file.delete();
		}
	}

}
