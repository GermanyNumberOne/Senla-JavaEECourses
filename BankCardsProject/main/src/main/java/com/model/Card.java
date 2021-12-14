package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Component
@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    @Column(name = "card_number")
    private String number;

    @Column(name = "password")
    private Short password;

    @Column(name = "money")
    private Long money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
