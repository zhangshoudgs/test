package com.zs.book.model;

import java.util.List;

/**
 * "showapi_res_body": {
		"allNum": 2903,
		"allPages": 146,
		"contentlist": [
			{
				"ct": "2015-07-30 01:10:29.995",
				"img": "http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0",
				"title": "�������Ͳ�~~~",
				"type": 2
			} 
		],
		"currentPage": 1,
		"maxResult": 20
	}
 * @author computer
 *
 */
public class ShowapiResBodyJoke {
	private int allNum;
	private int allPages;
	private List<ContentlistJokeBean> contentlist;
	private int currentPage;
	private int maxResult;
	@Override
	public String toString() {
		return "ShowapiResBody [allNum=" + allNum + ", allPages=" + allPages
				+ ", contentlist=" + contentlist + ", currentPage="
				+ currentPage + ", maxResult=" + maxResult + "]";
	}
	public ShowapiResBodyJoke(int allNum, int allPages,
			List<ContentlistJokeBean> contentlist, int currentPage, int maxResult) {
		super();
		this.allNum = allNum;
		this.allPages = allPages;
		this.contentlist = contentlist;
		this.currentPage = currentPage;
		this.maxResult = maxResult;
	}
	public ShowapiResBodyJoke() {
	}
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public List<ContentlistJokeBean> getContentlist() {
		return contentlist;
	}
	public void setContentlist(List<ContentlistJokeBean> contentlist) {
		this.contentlist = contentlist;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	
}
