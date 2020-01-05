package com.example.demo.exception.handler.message;

import java.util.stream.Stream;

import org.springframework.http.HttpStatus;

public enum DemoError {
	
	DEMO001(HttpStatus.BAD_REQUEST, "DEMO001", "Error number 1"),
	DEMO002(HttpStatus.BAD_REQUEST, "DEMO002", "Error number 2");
	
	private String code;
	private String message;
	private HttpStatus httpStatus;
	
	private DemoError(HttpStatus httpStatus, String code, String message) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private DemoError(String code, String message) {
		this.code = code;
		this.message = message;
	}

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
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static DemoError getByCode(String code) {
		return Stream.of(DemoError.values()).filter(e -> code.equals(e.getCode())).findFirst().orElse(DEMO001);
	}
}
