package com.example.algalogapi.domain.service;

import com.example.algalogapi.domain.entity.Customer;
import com.example.algalogapi.domain.entity.Delivery;
import com.example.algalogapi.domain.entity.StatusDelivery;
import com.example.algalogapi.domain.exception.BusinessRuleException;
import com.example.algalogapi.domain.repository.CustomerRepository;
import com.example.algalogapi.domain.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Delivery insert(Delivery delivery){

        var customer = customerRepository.findById(delivery.getCustomer().getId())
                        .orElseThrow(() -> new BusinessRuleException("Cliente não encontrado!!!"));

        delivery.setCustomer(customer);
        delivery.setStatus(StatusDelivery.PENDENTE);
        delivery.setDateOrdered(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
    public Optional<Delivery> findById(UUID id){
        return deliveryRepository.findById(id);
    }
    public List<Delivery> findAll(){
        return deliveryRepository.findAll();
    }
}
