package com.logical.login.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.logical.login.model.Response;

@RestControllerAdvice
public class LoginServiceExceptionHandler {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = { IOException.class })
	    public ResponseEntity<Response> unKnownException(IOException ex)
	    {
		 Response res = new Response();
		 res.setMessage("IO Exception comes");
		 res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());	
		 res.setPayload(ex.getMessage());
			return new ResponseEntity<Response>(res,HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
