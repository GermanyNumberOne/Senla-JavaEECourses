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
@Table(name = "reports")
public class Report extends BaseEntity {

    @Column(name = "is_success")
    private Boolean isSuccess;

    @OneToOne(mappedBy = "report",fetch = FetchType.LAZY)
    //@JoinColumn(name = "operation_id", referencedColumnName = "id")
    private Operation operation;

    @ManyToMany
    @JoinTable(name = "reports_categories", joinColumns = {@JoinColumn(name = "report_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<OperationCategory> categories;
}
