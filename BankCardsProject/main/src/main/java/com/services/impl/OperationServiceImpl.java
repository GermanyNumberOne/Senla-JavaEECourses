package com.services.impl;

import com.services.api.OperationService;
import com.dao.api.OperationDao;
import com.dto.OperationDto;
import lombok.RequiredArgsConstructor;
import com.model.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationDao operationDao;

    private final ModelMapper modelMapper;

    protected OperationDao getDefaultDao() {
        return operationDao;
    }

    @Override
    @Transactional
    public void create(OperationDto entity) {
        getDefaultDao().create(modelMapper.map(entity, Operation.class));
    }

    @Override
    @Transactional
    public OperationDto read(Long id) {
        Operation operation = operationDao.read(id);

        return operation == null ? null : modelMapper.map(operation, OperationDto.class);
    }

    @Override
    @Transactional
    public void update(OperationDto entity) {
        getDefaultDao().update(modelMapper.map(entity, Operation.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getDefaultDao().delete(id);
    }
}
