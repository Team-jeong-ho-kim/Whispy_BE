package com.example.whispy.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(S3AudioException.class)
    public ResponseEntity<ErrorResponse> s3AudioExceptionHandling(S3AudioException e) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(e.getErrorCode().getStatus())
                .build();

        return ResponseEntity.status(e.getErrorCode().getStatus()).body(errorResponse);
    }
}
