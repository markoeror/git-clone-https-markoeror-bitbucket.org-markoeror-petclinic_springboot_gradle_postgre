package com.eror.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VlasnikExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException(Exception exception){
		EntityErrorResponse vlasnikErrorResponse= new EntityErrorResponse();
		vlasnikErrorResponse.setId(HttpStatus.BAD_REQUEST.value());
		vlasnikErrorResponse.setPoruka(exception.getMessage());
		vlasnikErrorResponse.setTimeStamp(System.currentTimeMillis());		
		return new ResponseEntity<EntityErrorResponse>(vlasnikErrorResponse,HttpStatus.BAD_REQUEST);		
	}
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException404(EntityNotFoundException exception){
		EntityErrorResponse vlasnikErrorResponse= new EntityErrorResponse();
		vlasnikErrorResponse.setId(HttpStatus.NOT_FOUND.value());
		vlasnikErrorResponse.setPoruka(exception.getMessage());
		vlasnikErrorResponse.setTimeStamp(System.currentTimeMillis());		
		return new ResponseEntity<EntityErrorResponse>(vlasnikErrorResponse,HttpStatus.NOT_FOUND);
	}
}
