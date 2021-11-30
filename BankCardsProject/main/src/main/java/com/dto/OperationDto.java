package com.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OperationDto extends AbstractDto {
    private Long cost;

    private Long bankAccountId;

    private ReportDto report;
}
