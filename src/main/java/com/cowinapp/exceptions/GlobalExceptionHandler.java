package com.cowinapp.exceptions;

import com.cowinapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Method not allowed");
        //String path = request.getContextPath();
        List<String> description = new ArrayList<>();
        description.add("Method not supported");
        ApiErrors errors = new ApiErrors(message, description, status, LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Media type not supported");
        //String path = request.getContextPath();
        List<String> description = new ArrayList<>();
        description.add("Media type not supported");
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(message, description, status, LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Path variable is missing");
        //String path = request.getContextPath();
        List<String> description = new ArrayList<>();
        description.add("Missing Path variable");
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(message, description, status, LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Request Parameter is missing");
        List<String> description = new ArrayList<>();
        description.add("Missing Request parameter");
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(message, description, status, LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage(); //ex is exception class
        headers.add("desc", "Data type mismatch");
        List<String> description = new ArrayList<>();
        description.add("Data type - mismatch");
        //This is the body for the response entity
        ApiErrors errors = new ApiErrors(message, description, status, LocalDateTime.now());
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @ExceptionHandler(value=CentreNotFoundException.class)
    public ResponseEntity<Object> handleCentreNotFound(CentreNotFoundException ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Centre not found");
        List<String> description = new ArrayList<>();
        description.add("Requested centre is not found");
        ApiErrors errors = new ApiErrors(message, description, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }

    @ExceptionHandler(value=VaccineNotFoundException.class)
    public ResponseEntity<Object> handleVaccineNotFound(VaccineNotFoundException ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Vaccine not found");
        List<String> description = new ArrayList<>();
        description.add("Requested vaccine is not found");
        ApiErrors errors = new ApiErrors(message, description, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }

    @ExceptionHandler(value=PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFound(PersonNotFoundException ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Person not found");
        List<String> description = new ArrayList<>();
        description.add("Requested person is not found");
        ApiErrors errors = new ApiErrors(message, description, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex)  {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "other exception" +ex.getMessage());
        List<String> description = new ArrayList<>();
        description.add("Other exceptions");
        ApiErrors errors = new ApiErrors(message, description, HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
    }
}
