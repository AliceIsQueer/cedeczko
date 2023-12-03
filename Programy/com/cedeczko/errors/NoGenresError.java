package com.cedeczko.errors;

public class NoGenresError extends RuntimeException {
    public NoGenresError(String errorMessage) {
        super(errorMessage);
    }
}