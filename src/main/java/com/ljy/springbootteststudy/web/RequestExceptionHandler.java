package com.ljy.springbootteststudy.web;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import static java.util.stream.Collectors.toList;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> badRequest(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(toList()));
    }
}
