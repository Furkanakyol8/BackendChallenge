package com.example.backendchallenge.exception;

import com.example.backendchallenge.dto.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { CustomerNotFoundException.class , OrderNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request) {
        Response response = new Response(false, ex.getMessage());
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}