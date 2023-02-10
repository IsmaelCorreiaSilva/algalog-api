package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FinalizeDeliveryService {

    private SearchDeliveryService searchDeliveryService;
    private DeliveryRepository deliveryRepository;
    public void finalizeDelivery(UUID deliveryId){
        var delivery = searchDeliveryService.search(deliveryId);
        delivery.finalize();

        deliveryRepository.save(delivery);
    }
}
