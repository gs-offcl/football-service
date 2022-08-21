package com.football.league.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FootballException.class)
	public final ResponseEntity<Object> handleInvalidRequestParameterException(Exception ex, WebRequest req) {
		CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public final ResponseEntity<Object> handleResourceAccessExceptionException(Exception ex, WebRequest req) {
		CustomResponse customResponse = new CustomResponse(new Date(),
				"Internal Server Error. Please retry after sometime", req.getDescription(false));
		return new ResponseEntity<>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomResponse customResponse = new CustomResponse(new Date(), ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
	}
}
