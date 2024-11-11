package com.example.bookstore.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    BOOK_NOT_EXIST(40001, "Book is not exist", HttpStatus.NOT_FOUND);
    Integer code;
    String message;
    HttpStatus httpStatus;
}
