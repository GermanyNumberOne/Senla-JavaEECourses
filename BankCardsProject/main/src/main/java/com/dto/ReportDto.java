package com.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
public class ReportDto extends AbstractDto{
    private Boolean isSuccess;

    private Long operationId;

    private List<String> operationCategories;
}
