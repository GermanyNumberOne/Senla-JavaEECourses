package com.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Component
@Entity
@Table(name = "user_information")
public class UserInformation extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "address")
    private String address;

}
