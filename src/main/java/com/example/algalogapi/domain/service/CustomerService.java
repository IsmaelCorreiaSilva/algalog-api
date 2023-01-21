package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.entity.Customer;
import com.example.algalogapi.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Optional<Customer> findById(UUID id){
        return customerRepository.findById(id);
    }
    public Customer insert(Customer customer){
        return  customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
    public void delete(UUID id){
        customerRepository.deleteById(id);
    }
}
