package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto extends AbstractDto {
    private String name;

    private String surname;

    private List<CardDto> cards;

    private UserInformationDto userInfo;
}
