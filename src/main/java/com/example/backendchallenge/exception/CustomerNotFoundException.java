package com.example.backendchallenge.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException() {
        super("Customer Not Found.");
    }
}
