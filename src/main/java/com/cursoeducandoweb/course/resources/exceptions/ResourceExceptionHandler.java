package com.cursoeducandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursoeducandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//Interceptar as exceções que acontecerem para que esse objeto possa executar um possivel tratamento 
@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Para que seja capar de interceptar a requisição que deu exceção 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value() , error , e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
