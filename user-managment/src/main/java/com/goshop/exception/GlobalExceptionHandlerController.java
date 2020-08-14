package com.goshop.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CustomException e, WebRequest request) {
		LOG.error("ERROR", e);
		return new ResponseEntity<Object>(e.getMessage(), e.getHttpStatus());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(HttpServletResponse res, IllegalArgumentException e)
			throws IOException {
		LOG.error("ERROR", e);
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletResponse res, Exception e) throws IOException {
		LOG.error("ERROR", e);
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDuplicateKeyException(DataIntegrityViolationException e) {
		return new ResponseEntity<Object>("Entity Already Exists", HttpStatus.CONFLICT);
	}
}