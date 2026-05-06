package com.example.tripo.controllers;

import com.example.tripo.entities.Trip;
import com.example.tripo.exceptions.TripNotFoundException;
import com.example.tripo.repositories.TripRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @PostMapping("/")
    public ResponseEntity<?> createTrip(@RequestBody Trip trip){
        Trip createdTrip = tripRepository.save(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    @GetMapping("/")
    public ResponseEntity<?> getTripList(){
        List<Trip> tripList = tripRepository.findAll();
        return ResponseEntity.ok(tripList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrip(@PathVariable String id){
        Trip trip = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        return ResponseEntity.ok(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrip(@PathVariable String id, @RequestBody Trip trip){
        Trip tripToUpdate = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        tripToUpdate = trip;
        tripRepository.save(tripToUpdate);
        return ResponseEntity.ok(tripToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable String id){
        Trip tripToUpdate = tripRepository.findById(id).orElseThrow(TripNotFoundException::new);
        tripToUpdate.setDeletedAt(LocalDateTime.now());
        tripRepository.save(tripToUpdate);
        return ResponseEntity.ok(tripToUpdate);
    }

}
