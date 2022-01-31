package com.senla.courses.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilterDto {
    private boolean firstname = true;

    private boolean surname = true;

    private boolean cardsAmount = true;
}
