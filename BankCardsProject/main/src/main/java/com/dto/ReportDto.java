package com.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
public class ReportDto extends AbstractDto{
    private Boolean isSuccess;

    private List<String> operationCategories;


}