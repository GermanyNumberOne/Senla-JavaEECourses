package com.services.impl;

import com.dto.BankAccountDto;
import com.dto.UserInformationDto;
import com.model.UserInformation;
import com.services.api.OperationService;
import com.dao.api.OperationDao;
import com.dto.OperationDto;
import lombok.RequiredArgsConstructor;
import com.model.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
    private final OperationDao operationDao;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public List<OperationDto> getAll(){
        return operationDao.getAll().stream().map(value -> modelMapper.map(value, OperationDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(OperationDto entity) {
        operationDao.create(modelMapper.map(entity, Operation.class));
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
        operationDao.update(modelMapper.map(entity, Operation.class));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        operationDao.delete(id);
    }
}
