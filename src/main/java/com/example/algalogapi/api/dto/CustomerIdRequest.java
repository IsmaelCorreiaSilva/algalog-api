package com.example.algalogapi.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerIdRequest {
    @NotNull
    private UUID id;
}
