package com.senla.courses.project.services.api;

import com.senla.courses.project.dto.OperationDto;

public interface OperationService extends Service<OperationDto>{
    void create(Long bankAccountId, Long money, String category, Boolean isSuccess);
}
