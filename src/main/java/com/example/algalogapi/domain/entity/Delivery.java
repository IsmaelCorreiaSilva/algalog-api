package com.example.algalogapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tb_delivery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Customer customer;
    @Embedded
    private Addressee addressee;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime dateOrdered;
    private OffsetDateTime dateFinalization;

    public Event addEvent(String description){
        Event event = new Event();
        event.setDescription(description);
        event.setDateRecord(OffsetDateTime.now());
        event.setDelivery(this);

        this.getEvents().add(event);

        return event;
    }



}
