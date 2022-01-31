package com.senla.courses.project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Component
@Table(name = "users_roles")
public class UserRole extends BaseEntity {
    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<Role> roles;
}
