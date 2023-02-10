package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.entity.Delivery;
import com.example.algalogapi.domain.entity.Event;
import com.example.algalogapi.domain.exception.BusinessRuleException;
import com.example.algalogapi.domain.exception.EntityNotFoundException;
import com.example.algalogapi.domain.repository.DeliveryRepository;
import com.example.algalogapi.domain.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Event registerEvent(UUID deliveryId, String description){
        var delivery = searchDeliveryService.search(deliveryId);

        return delivery.addEvent(description);
    }
}
