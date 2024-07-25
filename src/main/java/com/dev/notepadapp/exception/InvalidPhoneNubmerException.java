package com.dev.notepadapp.exception;

public class InvalidPhoneNubmerException extends RuntimeException {
	
	private String message;

	public InvalidPhoneNubmerException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
