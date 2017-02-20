package com.zs.book.model;

/**
 * "contentlist": [ { "ct": "2015-07-30 01:10:29.995", "img":
 * "http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0", "title":
 * "�������Ͳ�~~~", "type": 2 } ],
 * 
 * @author computer
 *
 */
public class ContentlistJokeBean {
	private String ct;
	private String img;
	private String text;
	private String title;

	public ContentlistJokeBean(String ct, String img, String text, String title,
			int type) {
		super();
		this.ct = ct;
		this.img = img;
		this.text = text;
		this.title = title;
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private int type;

	@Override
	public String toString() {
		return "ContentlistBean [ct=" + ct + ", img=" + img + ", text=" + text
				+ ", title=" + title + ", type=" + type + "]";
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ContentlistJokeBean(String ct, String img, String title, int type) {
		super();
		this.ct = ct;
		this.img = img;
		this.title = title;
		this.type = type;
	}

	public ContentlistJokeBean() {
	}
}
