package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Component
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {

    @OneToMany(mappedBy = "bankAccount",cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "bankAccount",cascade = CascadeType.ALL)
    private List<Operation> operations;

}
