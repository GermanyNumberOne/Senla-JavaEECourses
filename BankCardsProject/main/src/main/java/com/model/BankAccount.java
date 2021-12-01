package com.model;

import liquibase.Liquibase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Component
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    @Column(name = "user_id")
    private List<User> users;

    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    @Column(name = "payment_id")
    private List<Operation> operations;

}
