package com.example.tripo.exceptions;

import org.springframework.stereotype.Component;

@Component
public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException() {
        super("Place not found!");
    }
}
