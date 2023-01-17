package com.axis.exception;

public class InvalidLoginDetailsException extends RuntimeException{
	String msg;
	public InvalidLoginDetailsException(String msg) {
		super();
		this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}

}
