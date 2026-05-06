package com.example.tripo.exceptions;

import org.springframework.stereotype.Component;

@Component
public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException() {
        super("Trip not found!");
    }
}
