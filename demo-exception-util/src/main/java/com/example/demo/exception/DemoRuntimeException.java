package com.example.demo.exception;

public class DemoRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	
	public DemoRuntimeException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public DemoRuntimeException(String errorCode) {
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
