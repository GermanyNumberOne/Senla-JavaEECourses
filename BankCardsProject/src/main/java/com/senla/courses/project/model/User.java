package com.senla.courses.project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Component
@Entity
@Table(name = "users")
@NamedEntityGraph(name = "graph.User", attributeNodes = {
        @NamedAttributeNode("userCards"),
})
public class User extends BaseEntity {
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> userCards;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
