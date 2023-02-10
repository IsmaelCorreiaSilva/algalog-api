package com.example.algalogapi.api.controller;

import com.example.algalogapi.api.assembler.CustomerAssembler;
import com.example.algalogapi.api.dto.CustomerRequest;
import com.example.algalogapi.api.dto.CustomerResponse;
import com.example.algalogapi.domain.entity.Customer;
import com.example.algalogapi.domain.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    private CustomerAssembler customerAssembler;
    @GetMapping
    public List<CustomerResponse> findAll(){
        return customerAssembler.toCollectionDto(customerService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable UUID id){
         return  customerService.findById(id)
                    .map(customer -> ResponseEntity.ok(customerAssembler.toEntityDto(customer)))
                    .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerAssembler.toEntityDomian(customerRequest);
        return customerService.insert(customer);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Customer> update(@PathVariable UUID id, @Valid @RequestBody CustomerRequest customerRequest){
        var customerResult = customerService.findById(id);

        if (!customerResult.isPresent()){
            return ResponseEntity.notFound().build();
        }
        var customer = customerAssembler.toEntityDomian(customerRequest);
        customer.setId(id);
        customer = customerService.update(customer);
        return ResponseEntity.ok(customer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        var customer = customerService.findById(id);
        if(!customer.isPresent()){
            ResponseEntity.notFound().build();
        }
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
