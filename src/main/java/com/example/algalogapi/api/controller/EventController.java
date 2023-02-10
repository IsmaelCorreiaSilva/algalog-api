package com.example.algalogapi.api.controller;

import com.example.algalogapi.api.assembler.EventAssembler;
import com.example.algalogapi.api.dto.EventRequest;
import com.example.algalogapi.api.dto.EventResponse;
import com.example.algalogapi.domain.service.EventService;
import com.example.algalogapi.domain.service.SearchDeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/events")
public class EventController {

    private EventService eventService;
    private SearchDeliveryService searchDeliveryService;
    private EventAssembler eventAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse save(@PathVariable UUID deliveryId,
                              @Valid @RequestBody EventRequest eventRequest){

        var event = eventService.registerEvent(deliveryId, eventRequest.getDescription());

        return  eventAssembler.toEntityDto(event);
    }
    @GetMapping
    public List<EventResponse> find(@PathVariable UUID deliveryId){
        var delivery = searchDeliveryService.search(deliveryId);

        return eventAssembler.toCollectionDto(delivery.getEvents());
    }

}
