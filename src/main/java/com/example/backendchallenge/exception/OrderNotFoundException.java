package com.example.backendchallenge.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException() {
        super("Order Not Found.");
    }
}
