package com.zs.book.model;

/**
 * { "showapi_res_code": 0, "showapi_res_error": "", "showapi_res_body": {
 * 
 * } }
 * 
 * @author computer
 *
 */
public class NewsBean {
	private int showapi_res_code;
	private String showapi_res_error;
	private ShowapiResBodyNews showapi_res_body;

	@Override
	public String toString() {
		return "NewsBean [showapi_res_code=" + showapi_res_code
				+ ", showapi_res_error=" + showapi_res_error
				+ ", showapi_res_body=" + showapi_res_body + "]";
	}

	public NewsBean() {
	}

	public NewsBean(int showapi_res_code, String showapi_res_error,
			ShowapiResBodyNews showapi_res_body) {
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

	public ShowapiResBodyNews getShowapi_res_body() {
		return showapi_res_body;
	}

	public void setShowapi_res_body(ShowapiResBodyNews showapi_res_body) {
		this.showapi_res_body = showapi_res_body;
	}

}
