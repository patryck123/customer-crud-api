package com.patryck.customers.controller;

import com.patryck.customers.dto.CustomerRequestDTO;
import com.patryck.customers.dto.CustomerResponseDTO;
import com.patryck.customers.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "CRUD completo de clientes")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @Operation(summary = "Cadastrar novo cliente")
    public ResponseEntity<CustomerResponseDTO> create(@Valid @RequestBody CustomerRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar clientes por nome")
    public ResponseEntity<List<CustomerResponseDTO>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(customerService.findByName(name));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id,
                                                       @Valid @RequestBody CustomerRequestDTO dto) {
        return ResponseEntity.ok(customerService.update(id, dto));
    }

    @PatchMapping("/{id}/deactivate")
    @Operation(summary = "Desativar cliente (soft delete)")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        customerService.deactivate(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover cliente permanentemente")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
