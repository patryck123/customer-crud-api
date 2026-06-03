package com.patryck.customers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    String name,

    @NotBlank @Email(message = "E-mail inválido")
    String email,

    @NotBlank(message = "Telefone é obrigatório")
    String phone,

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    String cpf
) {}
