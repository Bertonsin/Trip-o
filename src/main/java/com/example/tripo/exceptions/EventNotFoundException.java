package com.example.tripo.exceptions;

import org.springframework.stereotype.Component;

@Component
public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(){
        super("Event not found!");
    }

}
