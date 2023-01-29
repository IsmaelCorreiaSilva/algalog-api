package com.example.algalogapi.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryRequest {
    @Valid
    @NotNull
    private CustomerIdRequest customer;
    @Valid
    @NotNull
    private AddresseeRequest addressee;
    @NotNull
    private BigDecimal tax;
}
