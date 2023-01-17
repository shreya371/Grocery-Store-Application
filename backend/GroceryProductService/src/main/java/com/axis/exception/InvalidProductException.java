package com.axis.exception;

public class InvalidProductException extends RuntimeException{
	String msg;
	public InvalidProductException(String msg) {
		super();
		this.msg=msg;
	}
	
	public String getMsg() {
		return msg;
	}

}
