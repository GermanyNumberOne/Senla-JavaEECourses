package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@Component
public class Operation extends BaseEntity {

    private Long cost;
    @Autowired
    private Report report;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(report, operation.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, report);
    }
}
