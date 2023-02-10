package com.example.algalogapi.api.assembler;

import com.example.algalogapi.api.dto.CustomerRequest;
import com.example.algalogapi.api.dto.CustomerResponse;
import com.example.algalogapi.domain.entity.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CustomerAssembler {
    private ModelMapper modelMapper;

    public CustomerResponse toEntityDto(Customer customer){
        return modelMapper.map(customer, CustomerResponse.class);
    }
    public List<CustomerResponse> toCollectionDto(List<Customer> customers){
        return customers.stream()
            .map(this::toEntityDto)
            .collect(Collectors.toList());
    }
    public Customer toEntityDomian(CustomerRequest customerRequest){
        return modelMapper.map(customerRequest, Customer.class);
    }
}
