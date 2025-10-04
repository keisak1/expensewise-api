package com.nuno.expensewiseapi.dto;

import java.util.Date;

public record TransactionDTO(
        Long id,
        Float amount,
        String description,
        Date date,
        CategoryDTO category
) {}
