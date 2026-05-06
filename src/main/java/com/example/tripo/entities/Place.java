package com.example.tripo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Place {

    @Id
    private String id;

    private String name;

    private BigDecimal cost;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Destination destination;

    private LocalDateTime deletedAt;

}
