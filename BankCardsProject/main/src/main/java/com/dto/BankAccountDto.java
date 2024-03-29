package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountDto extends AbstractDto {
    private List<UserDto> users;

    private List<OperationDto> operations;
}
