package com.dev.notepadapp.exception;

public class NotepadNotFoundException extends RuntimeException {
	

	private String message;
	
	public NotepadNotFoundException(String message) {
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
