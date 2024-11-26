package com.example.demo.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger Log=LogManager.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler
	ResponseEntity<ResponseMessage> departmentHandler(DepartmentNotFoundException e){
		int status_code=HttpStatus.NOT_FOUND.value();
		HttpStatus httpStatus=HttpStatus.NOT_FOUND;
		String message=e.getMessage();
		Log.error(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(status_code, httpStatus, message));
		
	}
	

	@ExceptionHandler
	ResponseEntity<ResponseMessage> accountHandler(AccountNotFoundException e){
		int status_code=HttpStatus.NOT_FOUND.value();
		HttpStatus httpStatus=HttpStatus.NOT_FOUND;
		String message=e.getMessage();
		Log.error(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(status_code, httpStatus, message));
		
	}

}
