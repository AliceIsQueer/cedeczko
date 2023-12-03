package com.cedeczko.errors;

public class WrongEmailError extends RuntimeException {
    public WrongEmailError(String errorMessage) {
        super(errorMessage);
    }
}