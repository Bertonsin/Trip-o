package com.example.tripo.repositories;

import com.example.tripo.entities.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends MongoRepository<Destination, String> {
}
