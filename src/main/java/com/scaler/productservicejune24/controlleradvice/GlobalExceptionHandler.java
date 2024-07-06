package com.scaler.productservicejune24.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullpointerException()
    {
        ResponseEntity res = new ResponseEntity<>(
                "something went wrong in controller advice",
                HttpStatus.NOT_FOUND
        );
        return  res;

    }
}
