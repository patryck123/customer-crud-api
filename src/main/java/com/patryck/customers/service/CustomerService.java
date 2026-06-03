package com.patryck.customers.service;

import com.patryck.customers.dto.CustomerRequestDTO;
import com.patryck.customers.dto.CustomerResponseDTO;
import com.patryck.customers.entity.Customer;
import com.patryck.customers.exception.CustomerNotFoundException;
import com.patryck.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerResponseDTO create(CustomerRequestDTO dto) {
        if (customerRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado: " + dto.email());
        }
        Customer customer = Customer.builder()
            .name(dto.name())
            .email(dto.email())
            .phone(dto.phone())
            .cpf(dto.cpf())
            .build();
        return CustomerResponseDTO.from(customerRepository.save(customer));
    }

    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll().stream()
            .map(CustomerResponseDTO::from).toList();
    }

    @Transactional(readOnly = true)
    public CustomerResponseDTO findById(Long id) {
        return customerRepository.findById(id)
            .map(CustomerResponseDTO::from)
            .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado: " + id));
    }

    @Transactional(readOnly = true)
    public List<CustomerResponseDTO> findByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name).stream()
            .map(CustomerResponseDTO::from).toList();
    }

    @Transactional
    public CustomerResponseDTO update(Long id, CustomerRequestDTO dto) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado: " + id));
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setPhone(dto.phone());
        customer.setCpf(dto.cpf());
        return CustomerResponseDTO.from(customerRepository.save(customer));
    }

    @Transactional
    public void deactivate(Long id) {
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado: " + id));
        customer.setActive(false);
        customerRepository.save(customer);
    }

    @Transactional
    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Cliente não encontrado: " + id);
        }
        customerRepository.deleteById(id);
    }
}
