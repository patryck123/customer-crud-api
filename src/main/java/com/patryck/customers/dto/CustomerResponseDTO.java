package com.patryck.customers.dto;

import com.patryck.customers.entity.Customer;

import java.time.LocalDateTime;

public record CustomerResponseDTO(
    Long id,
    String name,
    String email,
    String phone,
    String cpf,
    Boolean active,
    LocalDateTime createdAt
) {
    public static CustomerResponseDTO from(Customer c) {
        return new CustomerResponseDTO(c.getId(), c.getName(), c.getEmail(),
            c.getPhone(), c.getCpf(), c.getActive(), c.getCreatedAt());
    }
}
