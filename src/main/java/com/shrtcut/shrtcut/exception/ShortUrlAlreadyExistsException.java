package com.shrtcut.shrtcut.exception;

public class ShortUrlAlreadyExistsException extends RuntimeException{
    public ShortUrlAlreadyExistsException(String message) {
        super(message);
    }
}
