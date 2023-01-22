package com.example.algalogapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tb_delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Customer customer;
    @Embedded
    private Addressee addressee;
    private BigDecimal tax;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(value = EnumType.STRING)
    private StatusDelivery status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateOrdered;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateFinalization;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Addressee getAddressee() {
        return addressee;
    }

    public void setAddressee(Addressee addressee) {
        this.addressee = addressee;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public StatusDelivery getStatus() {
        return status;
    }

    public void setStatus(StatusDelivery status) {
        this.status = status;
    }

    public LocalDateTime getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDateTime dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public LocalDateTime getDateFinalization() {
        return dateFinalization;
    }

    public void setDateFinalization(LocalDateTime dateFinalization) {
        this.dateFinalization = dateFinalization;
    }
}
