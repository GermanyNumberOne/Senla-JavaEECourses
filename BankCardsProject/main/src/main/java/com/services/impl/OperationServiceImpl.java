package com.services.impl;

import com.dao.api.OperationDao;
import com.dto.OperationDto;
import com.model.Operation;
import com.services.api.OperationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD

import java.util.List;
import java.util.stream.Collectors;
=======
>>>>>>> origin

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
