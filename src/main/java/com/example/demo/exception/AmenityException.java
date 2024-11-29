package com.example.demo.exception;

public class AmenityException extends CustomException {
    public AmenityException(String message) {
        super("Amenity Error: " + message);
    }
}
