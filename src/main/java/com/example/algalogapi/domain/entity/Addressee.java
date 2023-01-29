package com.example.algalogapi.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Addressee {

    @NotBlank
    @Column(name = "name_addressee")
    private String name;
    @NotBlank
    @Column(name = "street_addressee")
    private String street;
    @NotBlank
    @Column(name = "number_addressee")
    private String number;
    @NotBlank
    @Column(name = "complement_addressee")
    private String complement;
    @NotBlank
    @Column(name = "district_addressee")
    private String district;


}
