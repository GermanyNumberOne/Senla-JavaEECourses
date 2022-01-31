package com.senla.courses.project.model.enums;

import lombok.Getter;

@Getter
public enum OperationCategories {
    TRANSACTION(1l),
    SECOND(2l),
    THIRD(3l);
    private Long number;

    OperationCategories(Long number){
        this.number = number;
    }
}
