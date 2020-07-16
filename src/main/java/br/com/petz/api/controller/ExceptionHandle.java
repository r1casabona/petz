package br.com.petz.api.controller;

import br.com.petz.api.payload.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> entityNotFoundException(EntityNotFoundException ex) {
		return new ResponseEntity<>(ApiErrorResponse
				.builder()
				.code(HttpStatus.NOT_FOUND.value())
				.message(ex.getMessage()).build(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
		return new ResponseEntity<>(ApiErrorResponse
				.builder()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
