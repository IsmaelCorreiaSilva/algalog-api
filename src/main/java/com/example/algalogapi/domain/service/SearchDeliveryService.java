package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.entity.Delivery;
import com.example.algalogapi.domain.exception.EntityNotFoundException;
import com.example.algalogapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class SearchDeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery search(UUID deliveryId){
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada!!!"));

        return  delivery;
    }

}
