package com.sph.newspaper.exception;

public class ArticleAlreadyExistException extends ApplicationException {
	public ArticleAlreadyExistException() {
		this.error = new ErrorDetail("Article is already exist.");
	}
	
	public ArticleAlreadyExistException(String message) {
		this.error = new ErrorDetail(message);
	}
}
