package com.senla.courses.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    private String usersCardNumber;

    private String recipientCardNumber;

    private Long money;
}
