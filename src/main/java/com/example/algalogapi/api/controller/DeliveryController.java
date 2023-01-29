package com.example.algalogapi.api.controller;

import com.example.algalogapi.api.assembler.DeliveryAssembler;
import com.example.algalogapi.api.dto.DeliveryRequest;
import com.example.algalogapi.api.dto.DeliveryResponse;
import com.example.algalogapi.domain.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/deliveries")
@AllArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryAssembler deliveryAssembler;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponse insert(@Valid @RequestBody DeliveryRequest deliveryRequest){
        var delivery = deliveryAssembler.toEntityDomian(deliveryRequest);
        return deliveryAssembler.toEntityDto(deliveryService.insert(delivery));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> find(@PathVariable UUID id){
        return deliveryService.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toEntityDto(delivery)))
                .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping
    public List<DeliveryResponse> findAll(){
        return deliveryAssembler.toCollectionDto(deliveryService.findAll());
    }
}
