package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class BankAccount extends BaseEntity {
    @Autowired
    private List<Card> cards;
    @Autowired
    private List<Operation> operations;
}
