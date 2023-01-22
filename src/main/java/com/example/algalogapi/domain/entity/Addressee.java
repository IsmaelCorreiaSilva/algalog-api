package com.example.algalogapi.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Addressee {

    @Column(name = "name_addressee")
    private String name;
    @Column(name = "street_addressee")
    private String street;
    @Column(name = "number_addressee")
    private String number;
    @Column(name = "complement_addressee")
    private String complement;
    @Column(name = "district_addressee")
    private String district;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
