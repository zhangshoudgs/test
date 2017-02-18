package com.zs.book.model;

import android.text.TextUtils;

/**
 * "create_time": "2016-03-07 10:24:01", "image0":
 * "http://mpic.spriteapp.cn/ugc/2016/03/06/56dc3e07d30f8.jpg", "image1":
 * "http://mpic.spriteapp.cn/ugc/2016/03/06/56dc3e07d30f8.jpg", "image2":
 * "http://mpic.spriteapp.cn/ugc/2016/03/06/56dc3e07d30f8.jpg", "image3":
 * "http://mpic.spriteapp.cn/ugc/2016/03/06/56dc3e07d30f8.jpg", "text":
 * "\n        次奥 ，想骗老夫 ，肿么可能\n    ", "weixin_url":
 * "http://m.budejie.com/detail-17501776.html/",
 *
 */
public class ContentlistBuDeJieBean {
	private String create_time;
	private String image0;
	private String image1;
	private String image2;
	private String image3;
	private String text;
	private String weixin_url;

	public String getImageUri() {
		if (!isNull(getImage0())) {
			return image0;
		} else if (!isNull(getImage1())) {
			return image1;
		} else if (!isNull(getImage2())) {
			return image2;
		} else if (!isNull(getImage3())) {
			return image3;
		} else {
			return "";
		}
	}

	private boolean isNull(String content) {
		return TextUtils.isEmpty(content);
	}

	@Override
	public String toString() {
		return "ContentlistBuDeJieBean [create_time=" + create_time
				+ ", image0=" + image0 + ", image1=" + image1 + ", image2="
				+ image2 + ", image3=" + image3 + ", text=" + text
				+ ", weixin_url=" + weixin_url + "]";
	}

	public ContentlistBuDeJieBean(String create_time, String image0,
								  String image1, String image2, String image3, String text,
								  String weixin_url) {
		super();
		this.create_time = create_time;
		this.image0 = image0;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.text = text;
		this.weixin_url = weixin_url;
	}

	public ContentlistBuDeJieBean() {
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getImage0() {
		return image0;
	}

	public void setImage0(String image0) {
		this.image0 = image0;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getWeixin_url() {
		return weixin_url;
	}

	public void setWeixin_url(String weixin_url) {
		this.weixin_url = weixin_url;
	}

}
