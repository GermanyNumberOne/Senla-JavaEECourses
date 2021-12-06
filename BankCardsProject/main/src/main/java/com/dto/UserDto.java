package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto extends AbstractDto {
    private String firstname;

    private String surname;

    private Long bankAccountId;

    private List<CardDto> userCards;

    private UserInformationDto userInfo;
}
