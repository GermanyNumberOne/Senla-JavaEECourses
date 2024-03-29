package com.model;

import com.model.enums.OperationCategories;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Component
@Entity
@Table(name = "reports")
public class Report extends BaseEntity {

    @Column(name = "is_success")
    private Boolean isSuccess;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    private Operation operation;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_category_id")
    private OperationCategories operationCategory;

}
