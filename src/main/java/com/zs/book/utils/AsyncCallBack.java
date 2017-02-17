package com.zs.book.utils;

public interface AsyncCallBack<T> {

	public void onSuccess(T t);

	public void onFailed(String msg);
}
