package com.example.demo.exception;

public class BookingException extends CustomException {
    public BookingException(String message) {
        super("Booking Error: " + message);
    }
}
