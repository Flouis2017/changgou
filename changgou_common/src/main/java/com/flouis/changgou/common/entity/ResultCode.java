package com.flouis.changgou.common.entity;

public enum ResultCode {

	SUCCESS(20000, "请求成功"),
	FAIL(40000, "服务器异常，请求失败"),
	LOGIN_ERROR(40001, "用户名或密码出错"),
	STATE_ERROR(40002, "状态不可用-删除或冻结"),
	ACCESS_ERROR(40003, "权限不足"),
	REMOTE_ERROR(40004, "远程调用失败"),
	REACT_ERROR(40005, "重复操作");

	private int code;
	private String description;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	ResultCode(int code, String description){
		this.setCode(code);
		this.setDescription(description);
	}

}
