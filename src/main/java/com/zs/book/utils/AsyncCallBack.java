package com.zs.book.utils;

public interface AsyncCallBack<T> {

	void onSuccess(T t);

	void onFailed(String msg);
}
