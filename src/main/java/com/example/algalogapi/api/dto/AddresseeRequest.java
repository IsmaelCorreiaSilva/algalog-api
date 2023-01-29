package com.example.algalogapi.api.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    private String complement;
    @NotBlank
    private String district;
}
