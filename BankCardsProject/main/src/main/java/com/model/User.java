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
@Table(name = "users", schema = "public")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Column(name = "user_cards")
    private List<Card> userCards;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // @JoinColumn(name = "user_info", referencedColumnName = "id")
    private UserInformation userInfo;

}
