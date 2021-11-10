package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Component
public class BankAccount extends BaseEntity {
    @Autowired
    private List<Card> cards;
    @Autowired
    private List<Operation> operations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(cards, that.cards) || Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, operations);
    }
}
