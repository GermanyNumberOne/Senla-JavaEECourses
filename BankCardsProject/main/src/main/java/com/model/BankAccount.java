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

    @OneToMany(mappedBy = "bankAccount")
    @Column(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;

    @OneToMany(mappedBy = "bankAccount")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(name = "payment_id")
    private List<Operation> operations;

}
