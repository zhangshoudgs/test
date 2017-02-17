package com.zs.book.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class WebDataUtils {
	private static final String showapi_appid = "16436";
	private static final String showapi_sign = "714b756c93124a1ba98195c99590fa6f";

	/**
	 * 笑话 纯图片 接口连接
	 */
	public static String getJOKE_PIC(int newPage) {
		String JOKE_PIC = "https://route.showapi.com/341-2?maxResult=10&page="
				+ newPage + "&showapi_appid=" + showapi_appid
				+ "&showapi_timestamp=" + getTime()
				+ "&time=2015-07-10&showapi_sign=" + showapi_sign;
		System.out.println("---------JOKE_PIC  " + JOKE_PIC);
		return JOKE_PIC;
	}

	/**
	 * 笑话 纯文字 接口连接
	 */
	public static String getJOKE_TEXT(int newPage) {
		String JOKE_TEXT = "https://route.showapi.com/341-1?maxResult=20&page="
				+ newPage + "&showapi_appid=" + showapi_appid
				+ "&showapi_timestamp=" + getTime()
				+ "&time=2015-07-10&showapi_sign=" + showapi_sign;
		return JOKE_TEXT;
	}

	/**
	 * 新闻 接口连接
	 */
	public static String getNEWS(int newPage) {

		String NEWS = "https://route.showapi.com/198-1?num=10&page=" + newPage
				+ "&showapi_appid=" + showapi_appid + "&showapi_timestamp="
				+ getTime() + "&showapi_sign=" + showapi_sign;

		return NEWS;
	}

	/**
	 * 新闻 接口连接
	 */
	public static String getBUDEJIE(int newPage) {
		String BUDEJIE = "https://route.showapi.com/255-1?page=" + newPage
				+ "&showapi_appid=" + showapi_appid + "&showapi_timestamp="
				+ getTime() + "&title=&type=&showapi_sign=" + showapi_sign;
		return BUDEJIE;
	}

	private static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(new Date(System.currentTimeMillis()));
		return time;
	}
}
