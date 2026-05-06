package com.example.tripo;

import com.example.tripo.entities.Destination;
import com.example.tripo.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public void create(Destination destination) {
        destinationRepository.save(destination);
    }

    public List<Destination> getList(){
        return destinationRepository.findAll();
    }

    public Optional<Destination> getOne(String id){
        return destinationRepository.findById(id);
    }

    public void update(Destination destination){
        destinationRepository.save(destination);
    }

    public void delete(String id){
        destinationRepository.deleteById(id);
    }

}
