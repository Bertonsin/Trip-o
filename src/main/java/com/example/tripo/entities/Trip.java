package com.example.tripo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Trip {

    @Id
    private String id;

    private String name;

    private List<Event> events;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal participants;

    private BigDecimal estimatedCost;

    private Destination destination;

    private LocalDateTime deletedAt;

}
