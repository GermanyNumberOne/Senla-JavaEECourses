package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
}
