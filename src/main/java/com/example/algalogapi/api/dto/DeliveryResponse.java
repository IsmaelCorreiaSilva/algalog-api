package com.example.algalogapi.api.dto;

import com.example.algalogapi.domain.entity.StatusDelivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private UUID id;
    private CustomerSummaryResponse customer;
    private AddresseeResponse addressee;
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime dateOrdered;
    private OffsetDateTime dateFinalization;


}
