package com.sph.newspaper.exception;

public class ErrorDetail {
	private String errorMessage;

	public ErrorDetail() {
		this.errorMessage = "Somthing has gone wrong";
	}
	
	public ErrorDetail(String error) {
		this.errorMessage = error;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
