package com.patryck.customers.repository;

import com.patryck.customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
    List<Customer> findByActive(Boolean active);
    List<Customer> findByNameContainingIgnoreCase(String name);
}
