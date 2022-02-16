package com.salat23.waffles.exception;

import com.cloudinary.api.exceptions.NotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice()
public class EntityNotFoundHandler {


    @ExceptionHandler( {EntityNotFoundException.class })
    public final ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        return ResponseEntity.notFound().build();
    }

}
