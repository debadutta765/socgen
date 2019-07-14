package com.socgen.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomeExceptionHandler {

	@ExceptionHandler(value = ApplicationException.class)
	public ResponseEntity<AppErorr> handleApplicationException(ApplicationException exception) {

		AppErorr error = new AppErorr();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NoRecordException.class)
	public ResponseEntity<AppErorr> handleNoRecordException(NoRecordException exception) {

		AppErorr error = new AppErorr();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
