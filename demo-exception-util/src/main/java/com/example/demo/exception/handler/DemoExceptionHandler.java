package com.example.demo.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DemoException;
import com.example.demo.exception.DemoRuntimeException;
import com.example.demo.exception.handler.message.DemoError;
import com.example.demo.exception.handler.message.DemoExceptionResponse;

import static com.example.demo.exception.handler.message.DemoError.DEMO001;;

@RestControllerAdvice
public class DemoExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);
	
	@ExceptionHandler(DemoRuntimeException.class)
	public final ResponseEntity<DemoExceptionResponse> handleRuntimeException(DemoRuntimeException ex) {
		
		logger.error("Error Code: {}, Erro MEssage {}", ex.getErrorCode(), ex.getErrorMessage());
		
		DemoError error = DemoError.getByCode(ex.getErrorCode());
		DemoExceptionResponse exResponse = new DemoExceptionResponse(ex.getErrorCode(), ex.getErrorMessage());
		
		ResponseEntity<DemoExceptionResponse> response = new ResponseEntity<>(exResponse, error.getHttpStatus());
		return response;
	}

	@ExceptionHandler(DemoException.class)
	public final ResponseEntity<DemoExceptionResponse> handleApplicationException(DemoException ex) {
		
		logger.error("Error Code: {}, Erro MEssage {}", ex.getErrorCode(), ex.getErrorMessage());
		
		DemoError error = DemoError.getByCode(ex.getErrorCode());
		DemoExceptionResponse exResponse = new DemoExceptionResponse(ex.getErrorCode(), ex.getErrorMessage());
		
		ResponseEntity<DemoExceptionResponse> response = new ResponseEntity<>(exResponse, error.getHttpStatus());
		return response;
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<DemoExceptionResponse> handleException(Exception ex) {
		DemoError error = DEMO001;
		
		DemoExceptionResponse exResponse = new DemoExceptionResponse(error.getCode(), ex.getMessage());
		
		ResponseEntity<DemoExceptionResponse> response = new ResponseEntity<>(exResponse, error.getHttpStatus());
		return response;
	}
	
}
