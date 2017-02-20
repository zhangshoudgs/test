package com.zs.book.model;

import java.util.List;

/**
 * "allNum": 62166, "allPages": 3109, "contentlist": [ {
 * 
 * }, ], "currentPage": 1, "maxResult": 20
 *
 */
public class PageBean {
	private List<ContentlistBuDeJieBean> contentlist;

	public PageBean() {
	}

	@Override
	public String toString() {
		return "PageBean [contentlist=" + contentlist + "]";
	}

	public PageBean(List<ContentlistBuDeJieBean> contentlist) {
		super();
		this.contentlist = contentlist;
	}

	public List<ContentlistBuDeJieBean> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<ContentlistBuDeJieBean> contentlist) {
		this.contentlist = contentlist;
	}

}
