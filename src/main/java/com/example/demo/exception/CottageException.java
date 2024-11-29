package com.example.demo.exception;

public class CottageException extends CustomException {
    public CottageException(String message) {
        super("Cottage Error: " + message);
    }
}

