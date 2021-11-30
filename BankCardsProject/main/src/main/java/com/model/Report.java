package com.model;

import com.model.enums.OperationCategories;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Component
@Entity
@Table(name = "reports")
public class Report extends BaseEntity {

    @Column(name = "is_success")
    private Boolean isSuccess;

    @OneToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "operation_category_id")
    private OperationCategories operationCategory;

}
