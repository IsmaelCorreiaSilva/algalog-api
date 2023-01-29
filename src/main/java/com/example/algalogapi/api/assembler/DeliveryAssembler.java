package com.example.algalogapi.api.assembler;

import com.example.algalogapi.api.dto.DeliveryRequest;
import com.example.algalogapi.api.dto.DeliveryResponse;
import com.example.algalogapi.domain.entity.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {
    private ModelMapper modelMapper;
    public DeliveryResponse toEntityDto(Delivery delivery){
        return modelMapper.map(delivery, DeliveryResponse.class);
    }
    public List<DeliveryResponse> toCollectionDto(List<Delivery> deliveries){
        return deliveries.stream()
                .map(this::toEntityDto)
                .collect(Collectors.toList());
    }
    public Delivery toEntityDomian(DeliveryRequest delieryRequest){
        return  modelMapper.map(delieryRequest, Delivery.class);
    }

}
