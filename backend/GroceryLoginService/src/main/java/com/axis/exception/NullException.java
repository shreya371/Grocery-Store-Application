package com.axis.exception;

public class NullException extends RuntimeException{
	String msg;
	public NullException(String msg) {
		super();
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}
}
