package com.example.tripo.controllers;

import com.example.tripo.DestinationService;
import com.example.tripo.entities.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping()
@RestController("destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping("/")
    private ResponseEntity<?> createDestination(@RequestBody Destination destination){
        destinationService.create(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(destination);
    }

    @GetMapping("/")
    private ResponseEntity<List<Destination>> listDestination() {
        return ResponseEntity.ok(destinationService.getList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getOneDestination(@PathVariable String id){
        Optional<Destination> destination = destinationService.getOne(id);

        if(destination.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(destination);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateDestination(@PathVariable String id, @RequestBody Destination destination){
        Optional<Destination> existentDestination = destinationService.getOne(id);
        if(existentDestination.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        destinationService.update(destination);
        return ResponseEntity.ok(destination);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteDestination(@PathVariable String id){
        Optional<Destination> existantDestination = destinationService.getOne(id);
        if(existantDestination.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        destinationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
