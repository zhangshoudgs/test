package com.zs.book.model;

import java.util.List;

/**
 * "code": 200,
	"msg": "success",
	"newslist": [
		{
			
		},
		{
			"ctime": "2016-03-05 16:13",
			"description": "��Ѷ����",
			"picUrl": "http://img1.gtimg.com/ent/pics/hv1/12/220/2030/132056862_small.jpg",
			"title": "�����и����ܾ����ܼ��� ����Ӻ�Ӱ����������",
			"url": "http://ent.qq.com/a/20160305/040901.htm"
		}
	]
 * @author computer
 *
 */
public class ShowapiResBodyNews {
	private int code;
	private String msg;
	private List<ContentlistNewsBean> newslist;
	public ShowapiResBodyNews() {
	}
	public ShowapiResBodyNews(int code, String msg,
			List<ContentlistNewsBean> newslist) {
		super();
		this.code = code;
		this.msg = msg;
		this.newslist = newslist;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<ContentlistNewsBean> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<ContentlistNewsBean> newslist) {
		this.newslist = newslist;
	}
	@Override
	public String toString() {
		return "ShowapiResBodyNews [code=" + code + ", msg=" + msg
				+ ", newslist=" + newslist + "]";
	}
	
}
