package com.senla.courses.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "operation_categories")
public class OperationCategory extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Report> reports;
}
