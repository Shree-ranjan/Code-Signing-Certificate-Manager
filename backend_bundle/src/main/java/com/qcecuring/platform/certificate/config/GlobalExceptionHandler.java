package com.qcecuring.platform.certificate;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex) {
        List<Map<String,String>> details = ex.getBindingResult().getFieldErrors().stream()
            .map(err -> Map.of("field", err.getField(), "error", err.getDefaultMessage()))
            .collect(Collectors.toList());
        Map<String,Object> body = Map.of(
            "status", "error",
            "code", "VALIDATION_ERROR",
            "message", "Validation failed",
            "details", details,
            "traceId", UUID.randomUUID().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleGeneric(Exception ex) {
        Map<String,Object> body = Map.of(
            "status", "error",
            "code", "INTERNAL_ERROR",
            "message", "Internal server error",
            "traceId", UUID.randomUUID().toString()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}