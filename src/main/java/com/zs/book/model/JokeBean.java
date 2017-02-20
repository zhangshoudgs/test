package com.zs.book.model;
/**
 * {
	"showapi_res_code": 0,
	"showapi_res_error": "",
	"showapi_res_body": {
		"allNum": 2903,
		"allPages": 146,
		"contentlist": [
			{
				"ct": "2015-07-30 01:10:29.995",
				"text":
				"img": "http://img5.hao123.com/data/3_2ec986ed8d235ebb3bd562ed5b782eb6_0",
				"title": "�������Ͳ�~~~",
				"type": 2
			} 
		],
		"currentPage": 1,
		"maxResult": 20
	}
}
 * @author computer
 *
 */
public class JokeBean {
	private int showapi_res_code;
	private String showapi_res_error;
	private ShowapiResBodyJoke showapi_res_body;
	
	public JokeBean() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JokeBean [showapi_res_code=" + showapi_res_code
				+ ", showapi_res_error=" + showapi_res_error
				+ ", showapi_res_body=" + showapi_res_body + "]";
	}

	public JokeBean(int showapi_res_code, String showapi_res_error,
			ShowapiResBodyJoke showapi_res_body) {
		super();
		this.showapi_res_code = showapi_res_code;
		this.showapi_res_error = showapi_res_error;
		this.showapi_res_body = showapi_res_body;
	}



	public int getShowapi_res_code() {
		return showapi_res_code;
	}
	public void setShowapi_res_code(int showapi_res_code) {
		this.showapi_res_code = showapi_res_code;
	}
	public String getShowapi_res_error() {
		return showapi_res_error;
	}
	public void setShowapi_res_error(String showapi_res_error) {
		this.showapi_res_error = showapi_res_error;
	}
	public ShowapiResBodyJoke getShowapi_res_body() {
		return showapi_res_body;
	}
	public void setShowapi_res_body(ShowapiResBodyJoke showapi_res_body) {
		this.showapi_res_body = showapi_res_body;
	}
	
}
