package com.ktcu.login.domain;

public class LoginResult {

	private String code;
	private String message;
	private String returnUrl;
	private boolean isRefresh = false;
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public boolean isRefresh() {
		return isRefresh;
	}

	public void setRefresh(boolean refresh) {
		isRefresh = refresh;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
