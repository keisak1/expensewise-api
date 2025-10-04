package com.nuno.expensewiseapi.dto;

import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String email,
        String createdAt,
        List<TransactionDTO> transactions
) {}
