package com.goshop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

//    @ExceptionHandler(CustomException.class)
//    public void handleCustomException(HttpServletResponse res, CustomException e) throws IOException {
//        LOG.error("ERROR", e);
//        res.sendError(e.getHttpStatus().value(), "mm"+e.getMessage());
//    }

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(CustomException e, WebRequest request) {
        LOG.error("ERROR", e);
        return new ResponseEntity<Object>(e.getMessage(), e.getHttpStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(HttpServletResponse res, AccessDeniedException e) throws IOException {
        LOG.error("ERROR", e);
        return new ResponseEntity<Object>("Access denied", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(HttpServletResponse res, IllegalArgumentException e) throws IOException {
        LOG.error("ERROR", e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(HttpServletResponse res, Exception e) throws IOException {
        LOG.error("ERROR", e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}