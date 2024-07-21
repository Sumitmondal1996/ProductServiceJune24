package com.scaler.productservicejune24.controlleradvice;

import com.scaler.productservicejune24.dtos.ExceptionDto;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleNullpointerException()
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception happened");
        exceptionDto.setSolution("Please try again");
        ResponseEntity res = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
        return  res;

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException()
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("Please try with different id");
        ResponseEntity res = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.NOT_FOUND
        );
        return  res;

    }
}
