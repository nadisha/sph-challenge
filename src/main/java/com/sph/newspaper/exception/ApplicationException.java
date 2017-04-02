package com.sph.newspaper.exception;

public class ApplicationException extends Exception {
	protected ErrorDetail error;
	
	public ApplicationException() {
		super();
		this.error = new ErrorDetail();		
	}
	
	public ApplicationException(String message) {
		super(message);
		this.error = new ErrorDetail(message);		
	}

	public ErrorDetail getError() {
		return error;
	}			
}
