package com.zs.book.model;


/**
 *{
	"showapi_res_body": {
		"pagebean": {
			
		},
		"ret_code": 0
	}
} 
 *
 */
public class ShowapiResBodyBuDeJie {
	private PageBean pagebean;
	private int ret_code;
	public ShowapiResBodyBuDeJie() {
	}
	
	@Override
	public String toString() {
		return "ShowapiResBodyBuDeJie [pagebean=" + pagebean + ", ret_code="
				+ ret_code + "]";
	}

	public ShowapiResBodyBuDeJie(PageBean pagebean, int ret_code) {
		super();
		this.pagebean = pagebean;
		this.ret_code = ret_code;
	}

	public PageBean getPagebean() {
		return pagebean;
	}
	public void setPagebean(PageBean pagebean) {
		this.pagebean = pagebean;
	}
	public int getRet_code() {
		return ret_code;
	}
	public void setRet_code(int ret_code) {
		this.ret_code = ret_code;
	}
	
}
