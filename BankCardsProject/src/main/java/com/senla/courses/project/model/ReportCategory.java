package com.senla.courses.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "reports_categories")
public class ReportCategory {
    @ManyToMany
    private Long reportId;
    @ManyToMany
    private Long categoryId;
}
