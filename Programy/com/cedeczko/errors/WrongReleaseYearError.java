package com.cedeczko.errors;

public class WrongReleaseYearError extends RuntimeException {
    public WrongReleaseYearError(String errorMessage) {
        super(errorMessage);
    }
}
