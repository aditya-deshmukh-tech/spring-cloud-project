package com.cloud.medicine.project.medicinemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
@CrossOrigin(origins = "*")
public class MedicineManagementExecptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @CrossOrigin(origins = "*")
    public final ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(exception.getMessage());
        response.setDetail(Arrays.asList(exception.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.valueOf(500));
    }

}
