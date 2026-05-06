package com.example.tripo.repositories;

import com.example.tripo.entities.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {
}
