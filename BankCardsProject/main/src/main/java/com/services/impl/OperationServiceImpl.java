package com.services.impl;

import com.services.api.OperationService;
import com.dao.api.OperationDao;
import com.dto.OperationDto;
import lombok.RequiredArgsConstructor;
import com.model.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationDao operationDao;

    private final ModelMapper modelMapper;

    protected OperationDao getDefaultDao() {
        return operationDao;
    }

    @Override
    public void create(OperationDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Operation.class));
    }

    @Override
    public OperationDto read(Long id) {
        return modelMapper.map(getDefaultDao().read(id), OperationDto.class);
    }

    @Override
    public void update(OperationDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Operation.class));
    }

    @Override
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
