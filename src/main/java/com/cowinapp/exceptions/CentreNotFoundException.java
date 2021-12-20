package com.cowinapp.exceptions;

public class CentreNotFoundException extends RuntimeException {
    public CentreNotFoundException() {
    }

    public CentreNotFoundException(String message) {
        super(message);
    }
}
