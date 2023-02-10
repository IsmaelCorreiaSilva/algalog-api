package com.example.algalogapi.api.assembler;

import com.example.algalogapi.api.dto.EventResponse;
import com.example.algalogapi.domain.entity.Event;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EventAssembler {
    private ModelMapper modelMapper;

    public EventResponse toEntityDto(Event event){
        return modelMapper.map(event, EventResponse.class);
    }

    public List<EventResponse> toCollectionDto(List<Event> events){
        return events.stream()
                .map(this::toEntityDto)
                .collect(Collectors.toList());
    }


}
