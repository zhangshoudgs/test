package com.zs.book.model;

/**
 * "ctime": "2016-03-05 18:04",
	"description": "��Ѷ����",
	"picUrl": "http://img1.gtimg.com/ent/pics/hv1/50/225/2030/132058175_small.jpg",
	"title": "�ư��������¼��������²� ��������ֻ������",
	"url": "http://ent.qq.com/a/20160305/044730.htm"
 * @author computer
 *
 */
public class ContentlistNewsBean {
	private String ctime;
	private String description;
	private String picUrl;
	private String title;
	private String url;
	@Override
	public String toString() {
		return "ContentlistNewsBean [ctime=" + ctime + ", description="
				+ description + ", picUrl=" + picUrl + ", title=" + title
				+ ", url=" + url + "]";
	}
	public ContentlistNewsBean(String ctime, String description, String picUrl,
			String title, String url) {
		super();
		this.ctime = ctime;
		this.description = description;
		this.picUrl = picUrl;
		this.title = title;
		this.url = url;
	}
	public ContentlistNewsBean() {
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
