package com.example.tripo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Destination {

    @Id
    private String id;

    private String city;

    private String country;

    private String currency;

}
