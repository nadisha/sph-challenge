package com.sph.newspaper.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sph.newspaper.exception.ApplicationException;
import com.sph.newspaper.exception.ErrorDetail;

public class ApplicationRestController {
	@ExceptionHandler(ApplicationException.class)
	public ErrorDetail getError(HttpServletRequest request, ApplicationException exception) {
		exception.printStackTrace();
		return exception.getError();
	}
}
