package com.nuno.expensewiseapi.mapper;

import com.nuno.expensewiseapi.dto.CategoryDTO;
import com.nuno.expensewiseapi.dto.TransactionDTO;
import com.nuno.expensewiseapi.dto.UserDTO;
import com.nuno.expensewiseapi.model.User;

import java.util.List;

public class UserMapper {

    public static UserDTO mapToDTO(User user) {
        List<TransactionDTO> transactions = user.getTransactions().stream()
                .map(t -> new TransactionDTO(
                        t.getId(),
                        t.getAmount(),
                        t.getDescription(),
                        t.getDate(),
                        new CategoryDTO(
                                t.getCategory().getId(),
                                t.getCategory().getName(),
                                t.getCategory().getType().toString()
                        )
                ))
                .toList();

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                transactions
        );
    }
}