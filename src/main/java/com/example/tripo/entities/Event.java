package com.example.tripo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Document
public class Event {

    @Id
    private String id;

    private String name;

    private EventType type;

    private Place place;

    private BigDecimal cost;

    private LocalDateTime StartTime;

    private Time duration;

    private LocalDateTime deletedAt;

}
