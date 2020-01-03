package com.example.demo.exception.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.ResponseErrorHandler;

import com.example.demo.exception.DemoRuntimeException;
import com.example.demo.exception.handler.message.DemoExceptionResponse;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class DemoRestTemplateErrorHandler implements ResponseErrorHandler{

	private List<HttpMessageConverter<?>> messageConverters = Arrays.asList(new MappingJackson2HttpMessageConverter());
	
	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (httpResponse.getStatusCode().series() == CLIENT_ERROR ||
				httpResponse.getStatusCode().series() == SERVER_ERROR);
	}
	
	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		HttpMessageConverterExtractor<DemoExceptionResponse> errorMessageExtractor = 
				new HttpMessageConverterExtractor<>(DemoExceptionResponse.class, messageConverters);
		try {
			DemoExceptionResponse errorResponse = errorMessageExtractor.extractData(httpResponse);
			throw new DemoRuntimeException(errorResponse.getCode(), errorResponse.getMessage());
		} catch(IOException e) {
			throw e;
		}
	}
	
}
