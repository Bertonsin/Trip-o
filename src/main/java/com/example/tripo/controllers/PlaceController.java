package com.example.tripo.controllers;

import com.example.tripo.entities.Place;
import com.example.tripo.exceptions.PlaceNotFoundException;
import com.example.tripo.repositories.PlaceRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceRepository placeRepository;

    public PlaceController(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    @PostMapping("/")
    public ResponseEntity<?> createPlace(@RequestBody Place place){
        Place savedPlace = placeRepository.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlace);
    }

    @GetMapping("/")
    public ResponseEntity<?> getPlaceList(){
        List<Place> placeList = placeRepository.findAll();
        return ResponseEntity.ok(placeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlace(@PathVariable String id){
        Place place = placeRepository.findById(id).orElseThrow(PlaceNotFoundException::new);
        return ResponseEntity.ok(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlace(@PathVariable String id, @RequestBody Place place){
        Place placeToUpdate = placeRepository.findById(id).orElseThrow(PlaceNotFoundException::new);
        placeToUpdate = place;
        placeRepository.save(placeToUpdate);
        return ResponseEntity.ok(placeToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlace(@PathVariable String id){
        Place placeToUpdate = placeRepository.findById(id).orElseThrow(PlaceNotFoundException::new);
        placeToUpdate.setDeletedAt(LocalDateTime.now());
        placeRepository.save(placeToUpdate);
        return ResponseEntity.ok(placeToUpdate);
    }

}
