package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Component
@Entity
@Table(name = "operations")
public class Operation extends BaseEntity {

    @Column(name = "cost")
    private Long cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    private BankAccount bankAccount;

    @OneToOne(mappedBy = "operation",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Report report;

}
