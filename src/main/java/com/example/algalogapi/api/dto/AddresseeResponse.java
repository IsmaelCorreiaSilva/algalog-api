package com.example.algalogapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddresseeResponse {
    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;


}
