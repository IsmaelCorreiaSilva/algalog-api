package com.example.algalogapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerSummaryResponse {
    private UUID id;
    private String name;
}
