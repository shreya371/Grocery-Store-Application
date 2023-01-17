package com.axis.exception;
public class DataNotFoundException extends RuntimeException{
	String msg;
	public DataNotFoundException(String msg) {
		super();
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}
}
