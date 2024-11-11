package com.example.bookstore.exception;

import com.example.bookstore.dto.ApiResponse;
import com.example.bookstore.model.Books;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handlingApiException(ApiException exception){
        ErrorCode errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ApiResponse.<Books>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build());
    }
}
