package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.entity.Customer;
import com.example.algalogapi.domain.exception.BusinessRuleException;
import com.example.algalogapi.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Customer insert(Customer customer){
        var result = customerRepository.findByEmail(customer.getEmail())
                .stream().anyMatch(c -> c.equals(customer));

        if(result)
            throw new BusinessRuleException("Já existe cliente cadastrado com esse email!!!");

        return  customerRepository.save(customer);
    }
    @Transactional
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
    @Transactional
    public void delete(UUID id){
        customerRepository.deleteById(id);
    }
}
