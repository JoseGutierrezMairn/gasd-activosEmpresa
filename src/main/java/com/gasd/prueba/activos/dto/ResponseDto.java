package com.gasd.prueba.activos.dto;

import org.springframework.http.HttpStatus;


public class ResponseDto {

	private Object data;
	
	private String message;
	
	private HttpStatus httpStatus;

	public ResponseDto() {}

	public ResponseDto(Object data, String message, HttpStatus httpStatus) {
		this.data = data;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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
	
	
	
	
	
}
