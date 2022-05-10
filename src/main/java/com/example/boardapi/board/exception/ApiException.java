package com.example.boardapi.board.exception;

import com.example.boardapi.board.enums.ApiExceptionType;

public class ApiException extends Exception {
    private final ApiExceptionType type;

    private String[] args;

    public ApiException(ApiExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }

    public ApiException(ApiExceptionType type, String... args) {
        super(type.getMessage());
        this.type = type;
        this.args = args;
    }

    public ApiExceptionType getType() {
        return type;
    }

    public String[] getArgs() {
        return args;
    }
}
