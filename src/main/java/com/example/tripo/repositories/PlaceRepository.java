package com.example.tripo.repositories;

import com.example.tripo.entities.Place;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends MongoRepository<Place, String> {
}
