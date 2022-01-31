package com.senla.courses.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountDto extends AbstractDto {
    private UserDto user;

    private List<OperationDto> operations;
}
