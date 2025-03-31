package com.shrtcut.shrtcut.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ShortUrlAlreadyExistsException.class)
    public Map<String, String> handleShortUrlAlreadyExists(ShortUrlAlreadyExistsException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgument(IllegalArgumentException ex) {
        return Map.of("error", ex.getMessage());
    }
}
