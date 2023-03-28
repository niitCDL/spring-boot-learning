package com.example.exception;

import com.example.enums.CustomExceptionType;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private int code;
    private String message;

    public CustomException() {
    }

    public CustomException(CustomExceptionType customExceptionType) {
        this.code = customExceptionType.getCode();
        this.message = customExceptionType.getDesc();
    }

    public CustomException(CustomExceptionType customExceptionType,String message) {
        this.code = customExceptionType.getCode();
        this.message = message;
    }
}
