package com.example.algalogapi.api.controller;

import com.example.algalogapi.domain.entity.Delivery;
import com.example.algalogapi.domain.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery insert(@RequestBody Delivery delivery){
        return deliveryService.insert(delivery);
    }
}
