package com.example.demo.exception;

public class DemoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	
	public DemoException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public DemoException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
