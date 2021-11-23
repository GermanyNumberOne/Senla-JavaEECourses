package com.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserInformationDto extends AbstractDto {
    private String telephoneNumber;

    private UserDto user;

    private String address;
}
