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

    private Short password;

    private Long money;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
