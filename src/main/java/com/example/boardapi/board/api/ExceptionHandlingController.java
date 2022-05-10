package com.example.boardapi.board.api;

import com.example.boardapi.board.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = {"com.example.boardapi.board.api"})
public class ExceptionHandlingController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, String>> handleException(ApiException exception) {
        Map<String, String> result = new HashMap<>();

        String message = exception.getMessage();
        if (null != exception.getArgs()) {
            for (int index = 0; index < exception.getArgs().length; index++) {
                String arg = exception.getArgs()[index];
                message = message.replace("#" + index, arg);
            }
        }

        result.put("exception", exception.getType().name());
        result.put("message", message);

        return new ResponseEntity<>(result, exception.getType().getStatus());
    }
}