package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
	private int status_code;
	private HttpStatus httpStatus;
	private String message;
	
	public ResponseMessage(int status_code,HttpStatus httpStatus,String message) {
		this.status_code=status_code;
		this.httpStatus=httpStatus;
		this.message=message;
	}

	public int getStatus_code() {
		return status_code;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
