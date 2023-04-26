package com.example.asgn2.model.exceptions;

import com.example.asgn2.model.exceptions.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@AllArgsConstructor
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("not_found", "Requested resource was not found"),
                                    HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("generic_error", "Invalid input or other error occurred"),
                                    HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LabMissingError exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("lab_Missing", "No lab for that nr"),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MyError exc) {
        exc.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse("Error", exc.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

}