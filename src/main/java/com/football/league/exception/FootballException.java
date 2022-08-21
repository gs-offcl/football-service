package com.football.league.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FootballException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FootballException(String message) {
		super(message);
	}
}