package com.example.tripo.controllers;

import com.example.tripo.entities.Event;
import com.example.tripo.exceptions.EventNotFoundException;
import com.example.tripo.repositories.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @PostMapping("/")
    public ResponseEntity<?> createEvent(@RequestBody Event event){
        Event createdEvent = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent.getId());
    }

    @GetMapping("/")
    public ResponseEntity<?> getEventList(){
        List<Event> eventList = eventRepository.findAll();
        return ResponseEntity.ok(eventList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEvent(@PathVariable String id) {
        Event event = eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable String id, @RequestBody Event data){
        Event foundEvent = eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
        foundEvent = data;
        eventRepository.save(foundEvent);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id){
        Event foundEvent = eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
        foundEvent.setDeletedAt(LocalDateTime.now());
        eventRepository.save(foundEvent);
        return ResponseEntity.noContent().build();
    }

}
