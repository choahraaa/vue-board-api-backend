package com.example.boardapi.board.enums;

import org.springframework.http.HttpStatus;

public enum ApiExceptionType {

    SIGN_FAIL(HttpStatus.BAD_REQUEST, "요청 데이터와 일치하는 사용자 정보가 존재하지 않습니다.");
    private final HttpStatus status;

    private final String message;

    ApiExceptionType(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
