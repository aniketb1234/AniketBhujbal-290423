package com.avisys.cim.exception;



import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	// This method is an exception handler for JdbcSQLIntegrityConstraintViolationException,
	//which is thrown when their is a database constraint violation, such as a unique key violation.
  @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
  public ResponseEntity<?> handleJdbcSQLIntegrityConstraintViolationException(JdbcSQLIntegrityConstraintViolationException ex) {
	  
    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Unable to create Customer. Mobile number already present.");

  }
  

  
}