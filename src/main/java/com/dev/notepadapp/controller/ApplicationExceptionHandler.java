package com.dev.notepadapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dev.notepadapp.exception.InvalidPhoneNubmerException;
import com.dev.notepadapp.exception.NotepadNotFoundException;
import com.dev.notepadapp.exception.UserNotFoundException;
import com.dev.notepadapp.response.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotepadNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNotpadNotFoundException(NotepadNotFoundException exception) {
		ResponseStructure<String> responseStructure= new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserNotFoundException(UserNotFoundException exception) {
		ResponseStructure<String> responseStructure= new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPhoneNubmerException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidPhoneNumberException(InvalidPhoneNubmerException exception) {
		ResponseStructure<String> responseStructure= new ResponseStructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}


}
