package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CardDto extends AbstractDto {
    private String number;

    private Short password;

    private Long money;

    private Long userId;

}
