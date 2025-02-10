package com.writiq.blog.global.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Handle IllegalArgumentException
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
    Map<String, Object> errorResponse = new HashMap<>();

    List<Map<String, String>> errorDetails = new ArrayList<>();
    Map<String, String> error = new HashMap<>();
    errorResponse.put("status", "failure");
    error.put("field", "argument");
    error.put("message", ex.getMessage());
    errorDetails.add(error);

    errorResponse.put("error", errorDetails);
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  // Handle validation errors
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("status", "failure");

    List<Map<String, String>> errorDetails = new ArrayList<>();
    for (FieldError fieldError : result.getFieldErrors()) {
      Map<String, String> error = new HashMap<>();
      error.put("field", fieldError.getField());
      error.put("message", fieldError.getDefaultMessage());
      errorDetails.add(error);
    }

    errorResponse.put("error", errorDetails);
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

  // Handle DuplicateKeyException for duplicate email errors
  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseEntity<Map<String, Object>> handleDuplicateKeyException(DuplicateKeyException ex) {
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("status", "failure");

    List<Map<String, String>> errorDetails = new ArrayList<>();
    Map<String, String> error = new HashMap<>();
    error.put("field", "email");
    error.put("message", "Duplicate email found: " + ex.getMessage());
    errorDetails.add(error);

    errorResponse.put("error", errorDetails);
    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT); // HTTP 409 Conflict
  }

  // Handle other general exceptions
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("status", "failure");

    List<Map<String, String>> errorDetails = new ArrayList<>();
    Map<String, String> error = new HashMap<>();
    error.put("field", "general");
    error.put("message", ex.getMessage());
    errorDetails.add(error);

    errorResponse.put("error", errorDetails);
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
