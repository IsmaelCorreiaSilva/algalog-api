package com.example.algalogapi.api.controller;

import com.example.algalogapi.domain.entity.Customer;
import com.example.algalogapi.domain.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> find(@PathVariable UUID id){
         return  customerService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer insert(@Valid @RequestBody Customer customer){
        return customerService.insert(customer);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Customer> update(@PathVariable UUID id, @Valid @RequestBody Customer customer){
        var customerResponse = customerService.findById(id);

        if (!customerResponse.isPresent()){
            return ResponseEntity.notFound().build();
        }
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
