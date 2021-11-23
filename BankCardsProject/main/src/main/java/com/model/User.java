package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Component
@Entity
@Table(name = "users")
@NamedEntityGraph(name = "graph.User", attributeNodes = {
        @NamedAttributeNode("userCards"),
        @NamedAttributeNode("userInfo"),
        @NamedAttributeNode("bankAccount")
})
public class User extends BaseEntity {

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> userCards;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private UserInformation userInfo;

}
