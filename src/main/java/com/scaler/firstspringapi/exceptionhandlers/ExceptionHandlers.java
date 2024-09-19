package com.scaler.firstspringapi.exceptionhandlers;

import com.scaler.firstspringapi.dtos.ExceptionDTO;
import com.scaler.firstspringapi.dtos.ProductNotFoundExceptionDTO;
import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmaticException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("Please try after sometime");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(exceptionDTO,HttpStatus.FORBIDDEN);
        return response;
    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException exception){
//        ExceptionDTO exceptionDTO = new ExceptionDTO();
//        exceptionDTO.setMessage(exception.getMessage());
//        exceptionDTO.setResolution("Please try with different ID");
//        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(exceptionDTO,HttpStatus.NOT_FOUND);
//        return response;
//
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException exception){
        ProductNotFoundExceptionDTO exceptionDTO = new ProductNotFoundExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage() + ", ID = " +exception.getId());
        ResponseEntity<ProductNotFoundExceptionDTO> response = new ResponseEntity<>(exceptionDTO,HttpStatus.NOT_FOUND);
        return response;

    }
}
