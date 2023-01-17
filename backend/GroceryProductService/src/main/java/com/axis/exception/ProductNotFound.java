package com.axis.exception;

public class ProductNotFound extends RuntimeException {
	String msg;

	public ProductNotFound(String msg) {
		super();
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}

}
