package com.senla.courses.project.services.impl;

import com.senla.courses.project.dto.OperationDto;
import com.senla.courses.project.dao.api.OperationDao;
import com.senla.courses.project.model.Operation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperationServiceImplTest {

    @InjectMocks
    private OperationServiceImpl operationService;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private OperationDao operationDao;

    @Test
    void create() {
        OperationDto operation = new OperationDto();

        operationService.create(operation);
        Mockito.verify(operationDao, atLeastOnce()).create(modelMapper.map(operation, Operation.class));
    }

    @Test
    void getAll() {
        assertTrue(operationService.getAll().size() == 0);
        Mockito.verify(operationDao, atLeastOnce()).getAll();
    }

    @Test
    void read() {
        assertTrue(operationService.read(1l) == null);
        Mockito.verify(operationDao, atLeastOnce()).read(1l);
    }

    @Test
    void update() {
        OperationDto operation = new OperationDto();

        operationService.update(operation);
        Mockito.verify(operationDao, atLeastOnce()).update(modelMapper.map(operation, Operation.class));
    }

    @Test
    void delete() {
        operationService.delete(1l);
        Mockito.verify(operationDao, atLeastOnce()).delete(1l);
    }
}