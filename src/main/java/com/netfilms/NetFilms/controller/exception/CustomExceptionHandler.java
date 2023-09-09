package com.netfilms.NetFilms.controller.exception;

import com.netfilms.NetFilms.error.CustomExeption;
import com.netfilms.NetFilms.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
  @ExceptionHandler(CustomExeption.class)
  public ResponseEntity<Object> handlerCustomException(CustomExeption ex) {
    ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());

    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
  }
}
